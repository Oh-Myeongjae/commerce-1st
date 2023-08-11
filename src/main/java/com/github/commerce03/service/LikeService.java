package com.github.commerce03.service;

import com.github.commerce03.repository.commend.Commend;
import com.github.commerce03.repository.commend.CommendRepository;
import com.github.commerce03.repository.like.Like;
import com.github.commerce03.repository.like.LikeJpaRepository;
import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.repository.user.UserJpaRepository;
import com.github.commerce03.service.exeptions.NotFoundException;
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

    private final UserJpaRepository userJpaRepository;

    @Transactional
    public String commendLike(LikeRequestDto likeRequestDto) {
        Integer commendId = likeRequestDto.getCommendId();
        String userEmail = likeRequestDto.getUserEmail();

        UserEntity user = userJpaRepository.findByUserEmail(userEmail);
        if(user==null)throw new NotFoundException("유저정보를 찾을수 없습니다.");

        Optional<Like> like = likeJpaRepository.findByCommend_ComIdAndUser(commendId,user);
        if(like.isEmpty()){
            Commend commend = commendRepository.findById(commendId).orElseThrow(()->new RuntimeException("댓글이 존재하지 않습니다."));
            likeJpaRepository.save(LikeMapper.INSTANCE.LikeRequestDtoToLike(commend,user));
        }else{
            likeJpaRepository.delete(like.get());
        }
        return String.format("%s번 댓글에 대한 좋아요 요청이 정상처리 되었습니다.", commendId);
    }
}
