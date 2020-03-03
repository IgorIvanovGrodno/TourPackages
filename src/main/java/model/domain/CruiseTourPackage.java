package model.domain;

public class CruiseTourPackage extends TourPackage {

    public CruiseTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
        this.type=TourPackageType.CRUISE;
    }

}
