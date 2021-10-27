/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3Rentcar.Ciclo3Rentcar.Car;

import Ciclo3Rentcar.Ciclo3Rentcar.Gama.Gama;
import Ciclo3Rentcar.Ciclo3Rentcar.Message.Message;
import Ciclo3Rentcar.Ciclo3Rentcar.Reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Definicion de la Entidad y tabla car
 * @author carloscristancho
 */

@Entity
@Table (name="car")
public class Car implements Serializable{
    
    /**
     * Anotacion para que cada tabla tenga un incremento unico en el primary key
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    /**
     * Definicion de las variables de las cuales constara la tabla car
     */
    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    /**
     * Llave foranea con la tabla gama, en donde se ignora el atributo gama y car
     */
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties({"gama","cars"})
    private Gama gama;
    
    /**
     * Llave foranea de la tabla message, en donde se ingnora el atributo car y client
     */
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Message> messages;
    
    /**
     * Llave foranea de la tabla reservation, en donde se ingnora el atributo car y message
     */
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car","message"})
    private List<Reservation> reservations;

    /**
     * Metodo get del atributo idCar el cual es de tipo Integer
     * @return idCar
     */
    
    public Integer getIdCar() {
        return idCar;
    }
    
    /**
     * Metodo set del atributo idCar
     * @param idCar 
     */    

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }
    
    /**
     * Metodo get del atributo name el cual es de tipo String
     * @return name
     */    

    public String getName() {
        return name;
    }

    /**
     * Metodo set del atributo name
     * @param name 
     */    

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Metodo get del atributo brand el cual es de tipo String
     * @return brand
     */

    public String getBrand() {
        return brand;
    }
    
    /**
     * Metodo set del atributo brand
     * @param brand 
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    /**
     * Metodo get del atributo year el cual es de tipo Integer
     * @return year
     */

    public Integer getYear() {
        return year;
    }
    
    /**
     * Metodo set del atributo year
     * @param year 
     */

    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * Metodo get del atributo description el cual es de tipo String
     * @return description
     */

    public String getDescription() {
        return description;
    }
    
    /**
     * Metodo set del atributo description
     * @param description 
     */
    

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Metodo get de la llave foranea idGama
     * @return gama
     */

    public Gama getGama() {
        return gama;
    }
    
    /**
     * Metodo set de la llave foranea idGama
     * @param gama 
     */

    public void setGama(Gama gama) {
        this.gama = gama;
    }
    
    /**
     * Metodo get de la llave foranea idMessage
     * @return message
     */

    public List<Message> getMessages() {
        return messages;
    }
    
    /**
     * Metodo set de la llave foranea idMessage
     * @param message 
     */

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    /**
     * Metodo get de la llave foranea idReservation
     * @return reservation
     */

    public List<Reservation> getReservations() {
        return reservations;
    }
    
    /**
     * Metodo set de la llave foranea idReservation
     * @param reservation 
     */

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }  
}
