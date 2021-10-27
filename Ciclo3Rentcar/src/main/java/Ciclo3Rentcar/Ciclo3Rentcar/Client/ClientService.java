/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carloscristancho
 */

@Service
public class ClientService {
    @Autowired
    private ClientRepository metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }
    
    public Client save(Client client){
        if (client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){  
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client>g=metodosCrud.getClient(client.getIdClient());
            if (!g.isEmpty()){
                if (client.getEmail()!=null){
                    g.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!=null){
                    g.get().setPassword(client.getPassword());
                }
                if (client.getName()!=null){
                    g.get().setName(client.getName());
                }
                if (client.getAge()!=null){
                    g.get().setAge(client.getAge());
                }
                return metodosCrud.save(g.get());
            }       
        }
        return client;
    }
    
    public boolean delete(int id){
        Optional<Client> client=getClient(id);
        if (!client.isEmpty()){
            metodosCrud.delete(client.get());
            return true;
        }
        return false;
    }   
}
