package corseproject.repos;

import corseproject.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
     Topic findByTopicName (String topicName);
}