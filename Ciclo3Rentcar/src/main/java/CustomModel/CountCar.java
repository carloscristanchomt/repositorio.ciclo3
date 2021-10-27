/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomModel;

import Ciclo3Rentcar.Ciclo3Rentcar.Car.Car;

/**
 *
 * @author carloscristancho
 */
public class CountCar {
    
    private Long total;
    private Car car;

    public CountCar(Long total, Car car) {
        this.total = total;
        this.car = car;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
    
    
}
