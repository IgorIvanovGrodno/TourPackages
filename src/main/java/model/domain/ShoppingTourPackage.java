package model.domain;

public class ShoppingTourPackage extends TourPackage {

    public ShoppingTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
        this.type = TourPackageType.SHOPPING;
    }
}
