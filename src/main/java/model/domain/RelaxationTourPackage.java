package model.domain;

public class RelaxationTourPackage extends TourPackage {

    public RelaxationTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
        this.type=TourPackageType.RELAXATION;
    }
}
