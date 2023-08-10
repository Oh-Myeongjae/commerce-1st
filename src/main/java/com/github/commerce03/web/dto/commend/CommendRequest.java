package com.github.commerce03.web.dto.commend;

import lombok.Data;

@Data
public class CommendRequest {
    private String comContent;
    private String comAuthor;
    private Integer poId;
}

