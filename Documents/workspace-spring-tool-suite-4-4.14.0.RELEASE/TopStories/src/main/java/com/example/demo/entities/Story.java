package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Story {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(name = "title", nullable = false)
	    private String title;

	    @Column(name = "url", nullable = false)
	    private String url;

	    @Column(name = "score", nullable = false)
	    private int score;

	    @Column(name = "time_of_submission", nullable = false)
	    private LocalDateTime timeOfSubmission;

	    @Column(name = "user_submitted", nullable = false)
	    private String userSubmitted;
	    
//	    @OneToMany(targetEntity = StoryComments.class)
//	    List<StoryComments> listOfComments;
	
}
