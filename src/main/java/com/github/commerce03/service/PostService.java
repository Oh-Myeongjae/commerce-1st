package com.github.commerce03.service;

import com.github.commerce03.config.Provider.JwtTokenProvider;
import com.github.commerce03.repository.post.Post;
import com.github.commerce03.repository.post.PostJpaRepository;
import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.repository.user.UserJpaRepository;
import com.github.commerce03.service.exeptions.NotFoundException;
import com.github.commerce03.service.mapper.PostMapper;
import com.github.commerce03.web.dto.post.PostRequestDto;
import com.github.commerce03.web.dto.post.PostResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final JwtTokenProvider jwtTokenProvider;
    private final PostJpaRepository postJpaRepository;

    private final UserJpaRepository userJpaRepository;

    public List<PostResponseDto> findAllPost() {
        List<Post> postList = postJpaRepository.findAll();
        if(postList.isEmpty()) throw new RuntimeException("게시글이 존재하지 않습니다.");
        return postList.stream().map(PostMapper.INSTANCE::postToPostResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public String createPost(PostRequestDto postRequestDto, HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        if (token != null && jwtTokenProvider.validateToken(token)) {
            Claims claims = Jwts.parser().setSigningKey(jwtTokenProvider.getSecretKey()).parseClaimsJws(token).getBody();
            String tokenEmail = claims.getSubject();

            UserEntity user = userJpaRepository.findByUserEmail(tokenEmail);
            Post post = PostMapper.INSTANCE.PostRequestDtoToPost(postRequestDto,user);

            post.setPoCreatedAt(LocalDateTime.now());
            postJpaRepository.save(post);
            return "게시글이 성공적으로 작성되었습니다.";
        }else throw new NotFoundException("작성자를 찾을수 없습니다.");
    }

    @Transactional
    public String updatePost(Integer postId, PostRequestDto postRequestDto) {
        Post post = postJpaRepository.findById(postId).orElseThrow(()->new RuntimeException("게시글이 존재하지 않습니다."));
        post.setPost(postRequestDto);
        return "게시글이 성공적으로 수정되었습니다.";
    }
    @Transactional
    public String deletePost(Integer postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(()->new RuntimeException("게시글이 존재하지 않습니다."));
        postJpaRepository.delete(post);
        return "게시글이 성공적으로 삭제되었습니다.";
    }

    public List<PostResponseDto> findByEmail(String userEmail) {
        UserEntity user = userJpaRepository.findByUserEmail(userEmail);
        List<Post> list = postJpaRepository.findAllByUser(user);
        if(list.isEmpty())throw new NotFoundException("해당 이메일로 작성된 게시글을 찾을수 없습니다.");
        return list.stream().map(PostMapper.INSTANCE::postToPostResponseDto).collect(Collectors.toList());
    }
}
