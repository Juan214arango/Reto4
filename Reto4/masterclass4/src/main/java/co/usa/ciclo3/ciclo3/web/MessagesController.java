package co.usa.ciclo3.ciclo3.web;


import co.usa.ciclo3.ciclo3.model.Messages;
import co.usa.ciclo3.ciclo3.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @GetMapping("/all")
    public List<Messages> getMessages(){
        return messagesService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Messages> getMessages(@PathVariable("id") int id){
        return messagesService.getMessages(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages m){
        return messagesService.save(m);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages mensaje) {
        return messagesService.update(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messagesService.deleteMessage(messageId);
    }

}
