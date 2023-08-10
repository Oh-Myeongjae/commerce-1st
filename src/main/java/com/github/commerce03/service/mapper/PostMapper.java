package com.github.commerce03.service.mapper;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.web.dto.post.PostRequestDto;
import com.github.commerce03.web.dto.post.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public interface PostMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // 싱글톤
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    // 메소드
//    @Mapping(target = "poId", source = "poId")
//    @Mapping(target = "poTitle", source = "poTitle")
//    @Mapping(target = "poContent", source = "poContent")
    @Mapping(target = "poCreatedAt", source = "poCreatedAt", qualifiedByName = "convert")
    PostResponseDto postToPostResponseDto(Post post);

    @Mapping(target ="poTitle", source = "title")
    @Mapping(target ="poContent", source = "content")
    Post PostRequestDtoToPost(PostRequestDto postRequestDto);

    @Named("convert")
    static String localDateTimeToString(LocalDateTime localDateTime){
        if(localDateTime != null)return localDateTime.format(formatter);
        else return null;
    }
}
