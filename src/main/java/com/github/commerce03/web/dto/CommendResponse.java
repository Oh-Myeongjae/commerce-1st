package com.github.commerce03.web.dto;

import com.github.commerce03.repository.entity.Commend;
import lombok.Data;

import java.util.List;

@Data
public class CommendResponse {
    List<Commend> commends;
}
