package ua.kharkiv.yeremenko.exCollections.part3;

import java.util.HashMap;
import java.util.Map;


public class Parking {
    private static int parkingSize = 10;
    private static Integer parkingPlace;
    public static Integer newParkingPlace;
    public static Integer wrongParkingPlace = -1;
    private static Map<Integer, Car> map = new HashMap<>();

    public static Integer getNewParkingPlace() {
        return newParkingPlace;
    }
    public static Integer getWrongParkingPlace() {
        return wrongParkingPlace;
    }
    public boolean takeParkingPlace(Car car, Integer parkingPlace){
        if (map.containsValue(car)) {
            System.out.println("Car " + car.getNumberCar() + " is already parked in place " + parkingPlace);
            wrongParkingPlace = 0;
            return false;
        }
        if (map.containsKey(parkingPlace)) {
            while (parkingPlace!=parkingSize){
                parkingPlace++;
                if (takeParkingPlace(car, parkingPlace)) {
                    wrongParkingPlace = -1;
                    return true;
                }
            }
            return false;
        }
        else{
            map.put(parkingPlace, car);
            newParkingPlace = parkingPlace;
            wrongParkingPlace = -1;
            return true;
        }
    }

    public boolean runAway (Car car, Integer parkingPlace){
        if (map.containsKey(parkingPlace)) {
            map.remove(parkingPlace, car);
            return true;
        }
        else return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Parking))
            return false;
        Parking entry = (Parking) obj;
        return parkingPlace == entry.parkingPlace;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash = hash*17 + parkingPlace;
        return hash;
    }
}

class Car {
    private int numberCar;

    public Car(int numberCar) {
        this.numberCar = numberCar;
    }

    public int getNumberCar() {
        return numberCar;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car))
            return false;
        Car entry = (Car)obj;
        return numberCar == entry.numberCar;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash = hash*17 + numberCar;
        return hash;
    }
}
