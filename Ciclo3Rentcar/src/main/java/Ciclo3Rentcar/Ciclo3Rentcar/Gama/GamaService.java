/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Gama;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carloscristancho
 */

@Service
public class GamaService {
    @Autowired
    private GamaRepository metodosCrud;
    
    public List<Gama> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Gama> getGama(int idGama){
        return metodosCrud.getGama(idGama);
    }
    
    public Gama save(Gama gama){
        if (gama.getIdGama()==null){
            return metodosCrud.save(gama);
        }else{
            Optional<Gama> evt=metodosCrud.getGama(gama.getIdGama());
            if(evt.isEmpty()){  
                return metodosCrud.save(gama);
            }else{
                return gama;
            }
        }
    }    
        
    public Gama update(Gama gama){
        if (gama.getIdGama()!=null){
            Optional<Gama>g=metodosCrud.getGama(gama.getIdGama());
            if (!g.isEmpty()){
                if (gama.getName()!=null){
                    g.get().setName(gama.getName());
                }
                if (gama.getDescription()!=null){
                    g.get().setDescription(gama.getDescription());
                }
                return metodosCrud.save(g.get());
            }       
        }
        return gama;
    }
    
    public boolean delete(int id){
        Optional<Gama> gama=getGama(id);
        if (!gama.isEmpty()){
            metodosCrud.delete(gama.get());
            return true;
        }
        return false;
    }
}
