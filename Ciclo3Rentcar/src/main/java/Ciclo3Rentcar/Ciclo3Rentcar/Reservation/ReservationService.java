/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Reservation;

import CustomModel.CountCar;
import CustomModel.CountClient;
import CustomModel.StatusAmount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Creacion de la clase Reservation Service
 * @author carloscristancho
 */
@Service
public class ReservationService {
    
    /**
     * Creacion del metodo que exporta los metodos Create Read Update Delete
     */
    @Autowired
    private ReservationRepository metodosCrud;
    
    /**
     * El metodo getAll permite obtener los datos de alojados en .../api/Reservation/all
     * @return Todos los datos
     */
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    /**
     * El metodo getReservation permite obtener un unico dato a traves del primary key
     * @param idReservation
     * @return dato unico a traves de primery key
     */
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }
    
    /**
     * El metodo save permite guardar un nuevo registro siempre y cuando cumpla con la estructura designada
     * @param reservation
     * @return registro reservation
     */
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(evt.isEmpty()){  
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    /**
     * El metodo update permite actualizar un registro siempre y cuando el campo no sea null, en caso de que lo sea no lo hace
     * @param reservation
     * @return reservation
     */
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation>g=metodosCrud.getReservation(reservation.getIdReservation());
            if (!g.isEmpty()){
                if (reservation.getStartDate()!=null){
                    g.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return metodosCrud.save(g.get());
            }       
        }
        return reservation;
    }
    
    /**
     * El metodo delete permite eliminar un registro a traves de su primary key
     * @param id
     * @return boolean
     */
    public boolean delete(int id){
        Optional<Reservation> reservation=getReservation(id);
        if (!reservation.isEmpty()){
            metodosCrud.delete(reservation.get());
            return true;
        }
        return false;
    }
    
    public List<CountClient> getTopClient(){
        return metodosCrud.getTopClient();
    }
    
    public List<CountCar> getTopCar(){
        return metodosCrud.getTopCar();
    }
    
    public StatusAmount getStatusReport(){
        List<Reservation> completed=metodosCrud.getReservationByStatus("completed");
        List<Reservation> cancelled=metodosCrud.getReservationByStatus("cancelled");

        StatusAmount descAmt=new StatusAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return metodosCrud.getReservationPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
    
}
