package com.github.commerce03.service;

import com.github.commerce03.repository.commend.Commend;
import com.github.commerce03.repository.commend.CommendRepository;
import com.github.commerce03.repository.like.Like;
import com.github.commerce03.repository.like.LikeJpaRepository;
import com.github.commerce03.service.mapper.LikeMapper;
import com.github.commerce03.web.dto.like.LikeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeJpaRepository likeJpaRepository;
    private final CommendRepository commendRepository;

    @Transactional
    public String commendLike(LikeRequestDto likeRequestDto) {
        Integer commendId = likeRequestDto.getCommendId();
        Optional<Like> like = likeJpaRepository.findByCommend_ComId(commendId);
        if(like.isEmpty()){
            Commend commend = commendRepository.findById(commendId).orElseThrow(()->new RuntimeException("댓글이 존재하지 않습니다."));
            likeJpaRepository.save(LikeMapper.INSTANCE.LikeRequestDtoToLike(commend));
        }else{
            likeJpaRepository.delete(like.get());
        }
        return String.format("%s번 댓글에 대한 좋아요 요청이 정상처리 되었습니다.", commendId);
    }
}
