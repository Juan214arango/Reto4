package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Messages;
import co.usa.ciclo3.ciclo3.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository mesagesRepository;

    public List<Messages> getAll(){
        return mesagesRepository.getAll();
    }

    public Optional<Messages> getMessages(int id){
        return mesagesRepository.getMessages(id);
    }

    public Messages save(Messages m){
        if(m.getIdMessage()==null){
            return mesagesRepository.save(m);
        }else{
            Optional<Messages> paux=mesagesRepository.getMessages(m.getIdMessage());
            if(paux.isEmpty()){
                return mesagesRepository.save(m);
            }else{
                return m;
            }
        }
    }
    public Messages update(Messages message){
        if(message.getIdMessage()!=null){
            Optional<Messages> e= mesagesRepository.getMessages(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                mesagesRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessages(messageId).map(message -> {
            mesagesRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
