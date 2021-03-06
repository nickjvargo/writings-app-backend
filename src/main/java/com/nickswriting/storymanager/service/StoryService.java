package com.nickswriting.storymanager.service;

import com.nickswriting.storymanager.model.Story;
import com.nickswriting.storymanager.repo.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story addStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(Story story) {
        storyRepository.deleteById(story.getId());
        storyRepository.save(story);
        return story;
    }

    public List<Story> findAllStories() {
        return storyRepository.findAll();
    }

    public Story findStoryById(Long id) {
        return storyRepository.findById(id).get();
    }

    public void deleteStoryById(Long id) { storyRepository.deleteById(id); }
}
