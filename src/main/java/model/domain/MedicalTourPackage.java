package model.domain;

public class MedicalTourPackage extends TourPackage {

    public MedicalTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);
        this.type=TourPackageType.MEDICAL;
    }
}
