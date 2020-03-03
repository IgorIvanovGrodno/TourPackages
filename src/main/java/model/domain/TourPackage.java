package model.domain;

import java.util.Objects;

public abstract class TourPackage implements Comparable<TourPackage> {
    private String foodSystem;
    private String transport;
    private int numberOfDays;
    private int price;
    protected TourPackageType type;

    public TourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        this.foodSystem = foodSystem;
        this.transport = transport;
        this.numberOfDays = numberOfDays;
        this.price = price;
    }

    public String getFoodSystem() {
        return foodSystem;
    }

    public void setFoodSystem(String foodSystem) {
        this.foodSystem = foodSystem;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TourPackageType getType() {
        return type;
    }

    public int compareTo(TourPackage p) {
        int resultCompareType = getClass().getName().compareTo(p.getClass().getName());
        if (resultCompareType == 0) return price - p.getPrice();
        else return resultCompareType;
    }

    @Override
    public String toString() {
        return type + "{" +
                "foodSystem='" + foodSystem + '\'' +
                ", transport='" + transport + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return numberOfDays == that.numberOfDays &&
                price == that.price &&
                Objects.equals(foodSystem, that.foodSystem) &&
                Objects.equals(transport, that.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodSystem, transport, numberOfDays, price);
    }
}
