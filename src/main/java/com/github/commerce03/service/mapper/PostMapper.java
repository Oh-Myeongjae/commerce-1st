package com.github.commerce03.service.mapper;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.web.dto.post.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    // 싱글톤
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    // 메소드
    @Mapping(target = "poId", source = "po_id")
    @Mapping(target = "poTitle", source = "po_title")
    @Mapping(target = "poContent", source = "po_content")
    @Mapping(target = "poAuthor", source = "po_author")
    @Mapping(target = "poCreatedAt", source = "po_created_at")
    PostResponseDto postToPostResponseDto(Post post);

//    @Mapping(target = "cpu", source = "itemBody.spec.cpu")
//    @Mapping(target = "capacity", source = "itemBody.spec.capacity")
//    @Mapping(target = "storeSales", ignore = true)
//    @Mapping(target = "stock", expression = "java(0)")
//    ItemEntity idAndItemBodyToItemEntity(Integer id, ItemBody itemBody);
}
