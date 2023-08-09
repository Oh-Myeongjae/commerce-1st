package com.github.commerce03.service;

import com.github.commerce03.repository.like.LikeJpaRepository;
import com.github.commerce03.repository.post.Post;
import com.github.commerce03.repository.post.PostJpaRepository;
import com.github.commerce03.web.dto.like.LikeRequestDto;
import com.github.commerce03.web.dto.post.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeJpaRepository likeJpaRepository;
    private final PostJpaRepository postJpaRepository;

    @Transactional
    public String commendLike(LikeRequestDto likeRequestDto) {
//        Integer CommendId = likeRequestDto.getCommendId();
//        Optional<Like> like = likeJpaRepository.findByPost_PoId(poId);
//        if(like.isEmpty()){
//            Post post = postJpaRepository.findById(CommendId).orElseThrow(()->new RuntimeException("게시글이 존재하지 않습니다."));
//            likeJpaRepository.save(LikeMapper.INSTANCE.LikeRequestDtoToLike(post));
//        }else{
//            likeJpaRepository.delete(like.get());
//        }
//        return String.format("%s번 댓글에 대한 좋아요 요청이 정상처리 되었습니다.", poId);
        return "";
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
