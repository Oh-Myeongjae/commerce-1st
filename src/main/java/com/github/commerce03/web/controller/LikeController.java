package com.github.commerce03.web.controller;

import com.github.commerce03.service.LikeService;
import com.github.commerce03.web.dto.like.LikeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LikeController {

    private final LikeService likeService;
    @PostMapping("/commend/like")
    public String commendLike(@RequestBody LikeRequestDto likeRequestDto){
        log.info("POST /commend/like 요청이 들어왔습니다.");
        return likeService.commendLike(likeRequestDto);
    }

}
