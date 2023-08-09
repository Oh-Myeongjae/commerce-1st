package com.github.commerce03.web.dto.commend;

import com.github.commerce03.repository.commend.Commend;
import lombok.Data;

import java.util.List;

@Data
public class CommendResponse {
    List<Commend> commends;
}
