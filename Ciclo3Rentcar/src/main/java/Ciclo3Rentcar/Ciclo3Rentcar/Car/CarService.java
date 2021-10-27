/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Car;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carloscristancho
 */

@Service
public class CarService {
    
    @Autowired
    private CarRepository metodosCrud;
    
    public List<Car> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Car> getCar(int idCar){
        return metodosCrud.getCar(idCar);
    }
    
    public Car save(Car car){
        if (car.getIdCar()==null){
            return metodosCrud.save(car);
        }else{
            Optional<Car> evt=metodosCrud.getCar(car.getIdCar());
            if(evt.isEmpty()){  
                return metodosCrud.save(car);
            }else{
                return car;
            }
        }
    }
    
    public Car update(Car car){
        if (car.getIdCar()!=null){
            Optional<Car>g=metodosCrud.getCar(car.getIdCar());
            if (!g.isEmpty()){
                if (car.getName()!=null){
                    g.get().setName(car.getName());
                }
                if (car.getBrand()!=null){
                    g.get().setBrand(car.getBrand());
                }
                if (car.getYear()!=null){
                    g.get().setYear(car.getYear());
                }
                if (car.getDescription()!=null){
                    g.get().setDescription(car.getDescription());
                }
                return metodosCrud.save(g.get());
            }       
        }
        return car;
    }
    
    public boolean delete(int id){
        Optional<Car> car=getCar(id);
        if (!car.isEmpty()){
            metodosCrud.delete(car.get());
            return true;
        }
        return false;
    }
    
}
