package com.github.commerce03.service.mapper;

import com.github.commerce03.repository.commend.Commend;
import com.github.commerce03.repository.like.Like;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeMapper {
    // 싱글톤
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    // 메소드
//    @Mapping(target = "poId", source = "poId")
//    @Mapping(target = "poTitle", source = "poTitle")
//    @Mapping(target = "poContent", source = "poContent")
//    @Mapping(target = "poCreatedAt", source = "poCreatedAt", qualifiedByName = "convert")
//    PostResponseDto postToPostResponseDto(Post post);


    Like LikeRequestDtoToLike(Commend commend);

}
