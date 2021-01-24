package by.training.taxistation.domain.bin;

public class TaxiCar extends Car {
    private double tripCostPerKm;
    TaxiStation taxiStation;

    public TaxiCar(String brand, String model, int yearOfIssue, int volume, int maxSpeed, int fuelConsumption, int cost,
            double tripCostPerKm, TaxiStation taxiStation) {
        super(brand, model, yearOfIssue, volume, maxSpeed, fuelConsumption, cost);
        this.tripCostPerKm = tripCostPerKm;
        this.taxiStation = taxiStation;
    }

    public double getTripCostPerKm() {
        return tripCostPerKm;
    }

    public TaxiStation getTaxiStation() {
        return taxiStation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((taxiStation == null) ? 0 : taxiStation.hashCode());
        long temp;
        temp = Double.doubleToLongBits(tripCostPerKm);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaxiCar other = (TaxiCar) obj;
        if (taxiStation == null) {
            if (other.taxiStation != null)
                return false;
        } else if (!taxiStation.equals(other.taxiStation))
            return false;
        if (Double.doubleToLongBits(tripCostPerKm) != Double.doubleToLongBits(other.tripCostPerKm))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaxiCar [tripCostPerKm=" + tripCostPerKm + ", taxiStation=" + taxiStation + "]";
    }
}
