package com.github.commerce03.web.controller;

import com.github.commerce03.service.CommendService;
import com.github.commerce03.web.dto.CommendRequest;
import com.github.commerce03.web.dto.CommendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommendController {

    private final CommendService commentService;

    @PostMapping
    public String postCommend(@RequestBody CommendRequest commentsRequest) {

//        String comContent = commentsRequest.getComContent();
//        String comAuthor = commentsRequest.getComAuthor();
//        Integer poId = commentsRequest.getPoId();

        String result = commentService.postCommend(commentsRequest/*,poId*/);

        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteComByComId(@PathVariable Integer id){
        return commentService.deleteCommend(id);
    }

    @PutMapping("{id}")
    public String updateCommend(@PathVariable Integer id, @RequestBody CommendRequest commendRequest){
        String comContent = commendRequest.getComContent();
        String comAuthor = commendRequest.getComAuthor();

        return commentService.updateCommend(id, comContent,comAuthor);
    }

    @GetMapping
    public CommendResponse getAllCommend(){
        CommendResponse commendResponse = commentService.getAllCommend();
        return commendResponse;
    }
}
