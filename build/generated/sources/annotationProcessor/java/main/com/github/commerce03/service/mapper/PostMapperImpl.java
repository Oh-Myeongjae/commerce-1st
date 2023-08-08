package com.github.commerce03.service.mapper;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.web.dto.post.PostResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-08T23:56:24+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostResponseDto postToPostResponseDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponseDto postResponseDto = new PostResponseDto();

        postResponseDto.setPoId( post.getPo_id() );
        postResponseDto.setPoTitle( post.getPo_title() );
        postResponseDto.setPoContent( post.getPo_content() );
        postResponseDto.setPoAuthor( post.getPo_author() );
        postResponseDto.setPoCreatedAt( post.getPo_created_at() );

        return postResponseDto;
    }
}
