/**
 * 
 */
package com.sivalabs.blog.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.blog.resources.UserResource;
import com.sivalabs.blog.security.SecurityUser;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/users")
public class UserController 
{

	@RequestMapping(value="/authenticatedUser", method=RequestMethod.GET)
	public ResponseEntity<UserResource> getAuthenticatedUser() 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!= null)
		{
			Object userDetails = authentication.getPrincipal();
			if(userDetails != null && userDetails instanceof SecurityUser)
			{
				SecurityUser secUser = (SecurityUser) userDetails;
				String username = secUser.getUsername();
				List<String> roles = Arrays.asList(secUser.getDomainUser().getRole());
				UserResource authenticatedUser = new UserResource();
				authenticatedUser.setEmail(username);
				authenticatedUser.setRoles(roles);
				return new ResponseEntity<UserResource>(authenticatedUser,HttpStatus.OK); 
			}
		}
		return new ResponseEntity<UserResource>(HttpStatus.UNAUTHORIZED);
		
	}
}
