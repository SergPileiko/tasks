package by.training.taxistation.domain.bin;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private int yearOfIssue;
    private int volume;
    private int maxSpeed;
    private int fuelConsumption;
    private int cost;

    public Car(String brand, String model, int yearOfIssue, int volume, int maxSpeed, int fuelConsumption, int cost) {
        super();
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.volume = volume;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getVolume() {
        return volume;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Car o) {
        return this.cost - o.cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + cost;
        result = prime * result + fuelConsumption;
        result = prime * result + maxSpeed;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + volume;
        result = prime * result + yearOfIssue;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (cost != other.cost)
            return false;
        if (fuelConsumption != other.fuelConsumption)
            return false;
        if (maxSpeed != other.maxSpeed)
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (volume != other.volume)
            return false;
        if (yearOfIssue != other.yearOfIssue)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", yearOfIssue=" + yearOfIssue + ", volume=" + volume
                + ", maxSpeed=" + maxSpeed + ", fuelConsumption=" + fuelConsumption + ", cost=" + cost + "]";
    }
}
