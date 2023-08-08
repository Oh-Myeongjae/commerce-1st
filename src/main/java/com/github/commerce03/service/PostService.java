package com.github.commerce03.service;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.repository.post.PostJpaRepository;
import com.github.commerce03.service.mapper.PostMapper;
import com.github.commerce03.web.dto.post.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;
    public List<PostResponseDto> findAllPost() {
        List<Post> postList = postJpaRepository.findAll();
        if(postList.isEmpty()) throw new RuntimeException("게시글이 존재하지 않습니다.");
        List<PostResponseDto> responseDtoList = postList.stream().map(PostMapper.INSTANCE::postToPostResponseDto).collect(Collectors.toList());
        return responseDtoList;
    }
}
