package by.training.taxistation.domain.entity;

import java.util.List;
import by.training.taxistation.domain.bin.TaxiCar;
import by.training.taxistation.domain.bin.TaxiStation;

public class Printer {

    public void printToConsole(Object o) {
        System.out.println(o);
        System.out.println("");
    }

    public void printTaxiStation(TaxiStation taxiStation) {
        if (taxiStation == null) {
            return;
        }
        System.out.println("Taxi Station: " + taxiStation.getName());
        for (TaxiCar taxiCar : taxiStation.listTaxiCar) {
            this.printTaxiCar(taxiCar);
        }
        System.out.println("");
    }

    public void printListTaxiCar(List<TaxiCar> listTaxiCar) {
        if (listTaxiCar == null) {
            return;
        }
        for (TaxiCar taxiCar : listTaxiCar) {
            this.printTaxiCar(taxiCar);
        }
        System.out.println("");
    }

    public void printTaxiCar(TaxiCar taxiCar) {
        if (taxiCar == null) {
            return;
        }
        System.out.println("[" + taxiCar.getBrand() + " " + taxiCar.getModel() + ", year: " + taxiCar.getYearOfIssue()
                + ", cost: " + taxiCar.getCost() + ", fuel consumption: " + taxiCar.getFuelConsumption()
                + ", max speed " + taxiCar.getMaxSpeed() + ", trip cost per km: " + taxiCar.getTripCostPerKm() + "]");
    }
}