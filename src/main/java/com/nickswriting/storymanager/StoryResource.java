package com.nickswriting.storymanager;

import com.nickswriting.storymanager.model.Story;
import com.nickswriting.storymanager.service.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryResource {

    private final StoryService storyService;

    public StoryResource(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public ResponseEntity<List<Story>> getAllStories() {
        List<Story> stories = this.storyService.findAllStories();
        return new ResponseEntity<>(stories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Story> getStoryById(@PathVariable("id") Long id) {
        Story story = this.storyService.findStoryById(id);
        return new ResponseEntity<>(story, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Story> addStory(@RequestBody Story story) {
        Story newStory = storyService.addStory(story);
        return new ResponseEntity<>(newStory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Story> updateStory(@RequestBody Story story) {
        Story updatedStory = storyService.updateStory(story);
        return new ResponseEntity<>(updatedStory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStory(@PathVariable("id") Long id) {
        storyService.deleteStoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
