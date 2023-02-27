package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.cache.StoriesCustomCache;
import com.example.demo.entities.Story;
import com.example.demo.entities.StoryComments;
import com.example.demo.service.StoryServices;

@RestController
public class StoriesController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StoryServices storyServices;

	@GetMapping("/top-stories")
	public List<Story> getStoies() {

		return storyServices.getTopStories();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/past-stories")
	public List<Story> getPastStories() {

		if (StoriesCustomCache.listOfCachedStories.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			return restTemplate.exchange("http://localhost:8080/top-stories", HttpMethod.GET, entity, ArrayList.class)
					.getBody();

		} else {
			return StoriesCustomCache.listOfCachedStories;
		}
	}

	@PostMapping("/comments")
	public List<StoryComments> getListOfCommentsForStory(@RequestBody Story story) {

		long id = story.getId();
		return storyServices.getListOfComments(id);

	}

}
