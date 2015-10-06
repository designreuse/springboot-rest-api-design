package com.sivalabs.blog.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.sivalabs.blog.entities.Comment;
import com.sivalabs.blog.model.CommentDTO;
import com.sivalabs.blog.utils.ObjectCoverterUtil;

/**
 * @author Siva
 *
 */
public class CommentsResource extends AbstractCollectionResource<Comment, CommentDTO> implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	public CommentsResource(Page<Comment> pageData)
	{
		super(pageData);
	}

	@Override
	protected List<CommentDTO> populateDTOs(List<Comment> content)
	{
		List<CommentDTO> dtos = new ArrayList<>();
		for (Comment comment : content)
		{
			//dtos.add(new CommentDTO(comment));
			dtos.add(ObjectCoverterUtil.toCommentDTO(comment));
		}
		return dtos;
	}
	
}