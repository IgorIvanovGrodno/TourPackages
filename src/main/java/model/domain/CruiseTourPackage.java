package model.domain;

public class CruiseTourPackage extends TourPackage {
    static {
        type=TourPackageType.CRUISE;
    }
    public CruiseTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
    }

}
