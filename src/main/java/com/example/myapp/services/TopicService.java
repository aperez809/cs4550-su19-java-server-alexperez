package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepo;

  public List<Topic> findAllTopics() {
    return (List<Topic>) topicRepo.findAll();
  }

  public List<Topic> findTopicByTitle(String title) {
    return topicRepo.findTopicByTitle(title);
  }

  public Topic findTopicById(int topicId) {
    Optional<Topic> optional = topicRepo.findById(topicId);
    return optional.get();
  }

  public void deleteTopic(int topicId) {
    topicRepo.deleteById(topicId);
  }

  public void updateTopic(Topic target, int topicId) {
    Optional<Topic> optional = topicRepo.findById(topicId);
    Topic topic = optional.get();
    topic.setWidgets(target.getWidgets());
    topic.setLesson(target.getLesson());
    topic.setTitle(target.getTitle());

    topicRepo.save(topic);
  }

  public void createTopic(Topic topic) {
    topicRepo.save(topic);
  }

  public List<Topic> findTopicByLessonId(int lessonId) {
    return topicRepo.findTopicByLessonId(lessonId);
  }
}
