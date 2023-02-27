package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.cache.StoriesCustomCache;
import com.example.demo.entities.Story;
import com.example.demo.entities.StoryComments;
import com.example.demo.repositories.CommentsRepository;
import com.example.demo.repositories.StoryRepository;

@Service
public class StoryServices {

	@Autowired
	StoryRepository storyRepository;
	@Autowired
	CommentsRepository commentsRepository;
	
	@Scheduled(cron = "0 0/15 * * * *")
	public void clearRps() {
		StoriesCustomCache.listOfCachedStories.clear();
		StoriesCustomCache.listOfCachedStories=new ArrayList<Story>();   
	}
	
	public List<Story> getTopStories() {
		
		
		List<Story> listOfStories=storyRepository.findAllBytimeOfSubmission();
		if(!listOfStories.isEmpty()) {
			this.clearRps();
		StoriesCustomCache.listOfCachedStories=listOfStories;
		}
		return listOfStories;
		
		
	}
	
	
	public List<StoryComments> getListOfComments(long commentId) {
		
		List<Integer>l=Arrays.asList((int)commentId);
		Iterable<Integer>it=(Iterable<Integer>) l.iterator();
		return commentsRepository.findAllById(it);
		
	}
}
