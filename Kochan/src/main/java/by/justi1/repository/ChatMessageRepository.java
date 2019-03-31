package by.justi1.repository;

import by.justi1.model.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {
    List<ChatMessageModel> findAllByOrderByCreateDateAsc();
}