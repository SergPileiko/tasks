package by.training.taxistation.domain.bin;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation {
    private String name;
    public List<TaxiCar> listTaxiCar;

    public TaxiStation(String name) {
        this.name = name;
        this.listTaxiCar = new ArrayList<TaxiCar>();
    }

    public int totalCost() {
        int cost = 0;
        if (!this.listTaxiCar.isEmpty()) {
            for (int i = 0; i < this.listTaxiCar.size(); i++) {
                cost += this.listTaxiCar.get(i).getCost();
            }
        }
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaxiStation [name=" + name + ", listTaxiCar=" + listTaxiCar + "]";
    }

}