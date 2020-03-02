package model.domain;

public class RelaxationTourPackage extends TourPackage {
    static {
        type=TourPackageType.RELAXATION;
    }
    public RelaxationTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);

    }
}
