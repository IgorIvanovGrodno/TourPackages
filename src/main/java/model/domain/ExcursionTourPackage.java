package model.domain;

public class ExcursionTourPackage extends TourPackage {
    static {
        type=TourPackageType.EXCURSION;
    }
    public ExcursionTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
    }
}
