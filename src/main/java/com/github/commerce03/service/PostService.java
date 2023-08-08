package com.github.commerce03.service;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.repository.post.PostJpaRepository;
import com.github.commerce03.service.mapper.PostMapper;
import com.github.commerce03.web.dto.post.PostRequestDto;
import com.github.commerce03.web.dto.post.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;
    public List<PostResponseDto> findAllPost() {
        List<Post> postList = postJpaRepository.findAll();
        if(postList.isEmpty()) throw new RuntimeException("게시글이 존재하지 않습니다.");
        return postList.stream().map(PostMapper.INSTANCE::postToPostResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public String createPost(PostRequestDto postRequestDto) {
        Post post = PostMapper.INSTANCE.PostRequestDtoToPost(postRequestDto);
        post.setPoCreatedAt(LocalDateTime.now());
        postJpaRepository.save(post);
        return "게시글이 성공적으로 작성되었습니다.";
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
}
