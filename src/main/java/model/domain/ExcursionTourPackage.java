package model.domain;

public class ExcursionTourPackage extends TourPackage {

    public ExcursionTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
        this.type = TourPackageType.EXCURSION;
    }
}
