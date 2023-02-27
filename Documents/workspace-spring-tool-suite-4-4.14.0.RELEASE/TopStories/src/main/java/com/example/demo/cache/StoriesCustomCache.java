package com.example.demo.cache;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Story;

@Component
public class StoriesCustomCache {

public static List<Story> listOfCachedStories =new ArrayList<>();	
	
}
