package by.training.taxistation.domain.logic;

import by.training.taxistation.domain.bin.TaxiCar;
import by.training.taxistation.domain.bin.TaxiStation;

public class InitialTaxiStation {
    public static void initialTaxiStation(TaxiStation taxiStation) {
        if (taxiStation != null) {
            TaxiCar car1 = new TaxiCar("opel", "vectra", 1999, 1800, 145, 8, 3500, 1.0, taxiStation);
            TaxiCar car2 = new TaxiCar("opel", "astra", 2010, 2000, 150, 9, 9700, 2, taxiStation);
            TaxiCar car3 = new TaxiCar("vw", "passat", 2004, 1600, 130, 8, 6300, 1.5, taxiStation);
            TaxiCar car4 = new TaxiCar("bmw", "x3", 2008, 2200, 155, 10, 11800, 2.5, taxiStation);
            TaxiCar car5 = new TaxiCar("lada", "vesta", 2019, 1800, 140, 7, 14300, 2.0, taxiStation);
            taxiStation.listTaxiCar.add(car1);
            taxiStation.listTaxiCar.add(car2);
            taxiStation.listTaxiCar.add(car3);
            taxiStation.listTaxiCar.add(car4);
            taxiStation.listTaxiCar.add(car5);
        }
    }
}
