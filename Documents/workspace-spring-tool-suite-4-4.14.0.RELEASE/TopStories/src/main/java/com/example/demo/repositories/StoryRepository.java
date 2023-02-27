package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {
	
	@Query(value="SELECT * FROM story ORDER BY time_of_submission desc LIMIT 10",nativeQuery =true)
	public List<Story> findAllBytimeOfSubmission();
	

}
