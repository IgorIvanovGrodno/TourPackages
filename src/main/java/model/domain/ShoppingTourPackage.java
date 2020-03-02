package model.domain;

public class ShoppingTourPackage extends TourPackage {
    static {
        type=TourPackageType.SHOPPING;
    }
    public ShoppingTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);

    }
}
