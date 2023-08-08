package com.github.commerce03.web.controller;

import com.github.commerce03.service.PostService;
import com.github.commerce03.web.dto.post.PostResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @ApiOperation("모든 게시글을 검색")
    @GetMapping("/posts")
    public List<PostResponseDto> findAllPost(){
        log.info("GET /posts 요청이 들어왔습니다.");
        List<PostResponseDto> posts = postService.findAllPost();
        log.info("GET /posts 응답: " + posts);
        return posts;
    }
}
