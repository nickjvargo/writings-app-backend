package com.nickswriting.storymanager.repo;

import com.nickswriting.storymanager.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
