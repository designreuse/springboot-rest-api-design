/**
 * 
 */
package com.sivalabs.blog.utils;

import org.modelmapper.ModelMapper;

import com.sivalabs.blog.entities.Comment;
import com.sivalabs.blog.entities.Post;
import com.sivalabs.blog.model.CommentDTO;
import com.sivalabs.blog.model.PostDTO;

/**
 * @author Siva
 *
 */
public class ObjectCoverterUtil
{
	public static Post toPostEntity(PostDTO dto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Post.class);		
	}
	
	public static PostDTO toPostDTO(Post post)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(post, PostDTO.class);		
	}
	
	public static Comment toCommentEntity(CommentDTO dto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Comment.class);		
	}
	
	public static CommentDTO toCommentDTO(Comment comment)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(comment, CommentDTO.class);		
	}
}
