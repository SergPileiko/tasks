package by.training.taxistation.domain;

/*Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. 
Рассчитать стоимость автопарка. 
Провести сортировку автомобилей парка по расходу топлива. 
Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.*/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import by.training.taxistation.domain.bin.Car;
import by.training.taxistation.domain.bin.TaxiCar;
import by.training.taxistation.domain.bin.TaxiStation;
import by.training.taxistation.domain.comparator.FuelConsumptionComparator;
import by.training.taxistation.domain.entity.Printer;
import by.training.taxistation.domain.logic.InitialTaxiStation;
import by.training.taxistation.domain.logic.SpeedParameter;

public class Runner {
    public static void main(String[] args) {
        int cost;
        int beginSpeed;
        int endSpeed;

        beginSpeed = 135;
        endSpeed = 151;

        TaxiStation yandexTaxi = new TaxiStation("YandexTaxi");
        Printer printer = new Printer();

        InitialTaxiStation.initialTaxiStation(yandexTaxi);
        printer.printTaxiStation(yandexTaxi);

        cost = yandexTaxi.totalCost();
        printer.printToConsole("Total cost = " + cost);

        Comparator<Car> fuelComparator = new FuelConsumptionComparator();

        Collections.sort(yandexTaxi.listTaxiCar, fuelComparator);
        printer.printTaxiStation(yandexTaxi);

        List<TaxiCar> listCarRangeSpeed = SpeedParameter.findCarBySpeed(yandexTaxi, beginSpeed, endSpeed);
        printer.printListTaxiCar(listCarRangeSpeed);
    }
}
