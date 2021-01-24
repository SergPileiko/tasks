package by.training.taxistation.domain.logic;

import java.util.ArrayList;
import java.util.List;
import by.training.taxistation.domain.bin.TaxiCar;
import by.training.taxistation.domain.bin.TaxiStation;

public class SpeedParameter {

    public static List<TaxiCar> findCarBySpeed(TaxiStation taxiStation, int begin, int end) {
        int maxSpeed = 0;
        int x = begin;
        int y = end;
        if (x > y) {
            x = end;
            y = begin;
        }
        if (taxiStation == null) {
            return null;
        }
        List<TaxiCar> listTaxiCarSpeed = new ArrayList<TaxiCar>();
        for (TaxiCar taxiCar : taxiStation.listTaxiCar) {
            maxSpeed = taxiCar.getMaxSpeed();
            if (maxSpeed >= x && maxSpeed <= y) {
                listTaxiCarSpeed.add(taxiCar);
            }
        }
        return listTaxiCarSpeed;
    }
}
