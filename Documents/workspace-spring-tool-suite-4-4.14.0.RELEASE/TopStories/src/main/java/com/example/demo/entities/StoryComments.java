package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class StoryComments {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
  int commentId;
	String Comment;
	
//	@ManyToOne
//    @JoinColumn(name="id", nullable=false)
//     Story story;
//	
	
}
