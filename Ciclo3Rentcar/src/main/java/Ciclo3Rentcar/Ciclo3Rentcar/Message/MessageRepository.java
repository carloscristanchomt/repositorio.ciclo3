/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Message;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carloscristancho
 */

@Repository
public class MessageRepository {

    @Autowired
    private MessageInterface crud;
    
    public List<Message> getAll(){
        return(List<Message>) crud.findAll();
    }
    
    public Optional <Message> getMessage(int id){
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    }
    
    public void delete (Message message){
        crud.delete(message);
    }    
    
}
