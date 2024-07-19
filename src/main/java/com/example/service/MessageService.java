package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepo;

    public Message createMessage(Message message) {
        return messageRepo.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    public Message getMessageById(Integer id) {
        Optional<Message> optionalMessage = messageRepo.findById(id);
        if(optionalMessage.isPresent()) {
            return optionalMessage.get();
        }
        return null;
    }

    public int deleteMessageById(Integer id) {
        if(messageRepo.existsById(id)) {
            messageRepo.deleteById(id);
            return 1;
        }
        // No message deleted
        return 0;
    }

    public int updateMessage(Integer id, Message message) {
        if(messageRepo.existsById(id)) {
            messageRepo.save(message);
            return 1;
        }
        // If user doesnt exist by id
        return 0;
    }

    public List<Message> getAllMessagesFromUser(Integer id) {
        return messageRepo.findAllByPostedByID(id);
    }

}
