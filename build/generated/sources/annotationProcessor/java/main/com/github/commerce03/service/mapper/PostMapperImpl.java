package com.github.commerce03.service.mapper;

import com.github.commerce03.repository.post.Post;
import com.github.commerce03.web.dto.post.PostRequestDto;
import com.github.commerce03.web.dto.post.PostResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-09T03:14:44+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostResponseDto postToPostResponseDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponseDto postResponseDto = new PostResponseDto();

        postResponseDto.setPoCreatedAt( PostMapper.localDateTimeToString( post.getPoCreatedAt() ) );
        postResponseDto.setPoId( post.getPoId() );
        postResponseDto.setPoTitle( post.getPoTitle() );
        postResponseDto.setPoContent( post.getPoContent() );

        return postResponseDto;
    }

    @Override
    public Post PostRequestDtoToPost(PostRequestDto postRequestDto) {
        if ( postRequestDto == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.poTitle( postRequestDto.getTitle() );
        post.poContent( postRequestDto.getContent() );

        return post.build();
    }
}
