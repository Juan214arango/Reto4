package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Messages;
import co.usa.ciclo3.ciclo3.repository.crud.MessagesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessagesRepository {

    @Autowired
    private MessagesCrudRepository messagesCrudRepository;

    public List<Messages> getAll(){
        return (List<Messages>) messagesCrudRepository.findAll();
    }
    public Optional<Messages> getMessages(int id){
        return  messagesCrudRepository.findById(id);
    }

    public Messages save(Messages m){
        return messagesCrudRepository.save(m);
    }

    public void delete(Messages m){
        messagesCrudRepository.delete(m);
    }
 
} 

