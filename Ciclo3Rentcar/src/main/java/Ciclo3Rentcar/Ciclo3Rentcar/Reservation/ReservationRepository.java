/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Reservation;

import Ciclo3Rentcar.Ciclo3Rentcar.Car.Car;
import Ciclo3Rentcar.Ciclo3Rentcar.Client.Client;
import CustomModel.CountCar;
import CustomModel.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carloscristancho
 */

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationInterface crud;
    
    public List<Reservation> getAll(){
        return(List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservation(int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    
    public void delete (Reservation reservation){
        crud.delete(reservation);
    }    
    
    public List<Reservation> getReservationByStatus(String status){
        return crud.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return crud.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=crud.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            
            //Categoria cat=(Categoria) report.get(i)[0];
            //Long cantidad=(Long) report.get(i)[1];
            //CountCategoria cc=new CountCategoria(cantidad,cat);
            //res.add(cc);
            
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }

    public List<CountCar> getTopCar(){
        List<CountCar> res=new ArrayList<>();

        List<Object[]> report=crud.countTotalReservationByCar();
        for(int i=0;i<report.size();i++){
            
            //Categoria cat=(Categoria) report.get(i)[0];
            //Long cantidad=(Long) report.get(i)[1];
            //CountCategoria cc=new CountCategoria(cantidad,cat);
            //res.add(cc);
            
            res.add(new CountCar((Long) report.get(i)[1],(Car)report.get(i)[0] ));
        }
        return res;
    }  
    
}
