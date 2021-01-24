package by.training.taxistation.domain.comparator;

import java.util.Comparator;
import by.training.taxistation.domain.bin.Car;

public class FuelConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getFuelConsumption() - o2.getFuelConsumption();
    }
}
