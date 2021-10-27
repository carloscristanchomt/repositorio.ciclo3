/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Message;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carloscristancho
 */

@Service
public class MessageService {
    @Autowired
    private MessageRepository metodosCrud;
    
    public List<Message> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }
    
    public Message save(Message message){
        if (message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){  
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }    
        
    public Message update(Message message){
        if (message.getIdMessage()!=null){
            Optional<Message>g=metodosCrud.getMessage(message.getIdMessage());
            if (!g.isEmpty()){
                if (message.getMessageText()!=null){
                    g.get().setMessageText(message.getMessageText());
                }

                return metodosCrud.save(g.get());
            }       
        }
        return message;
    }
    
    public boolean delete(int id){
        Optional<Message> message=getMessage(id);
        if (!message.isEmpty()){
            metodosCrud.delete(message.get());
            return true;
        }
        return false;
    }
}
