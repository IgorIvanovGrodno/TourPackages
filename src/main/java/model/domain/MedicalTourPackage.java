package model.domain;

public class MedicalTourPackage extends TourPackage {
    static {
        type=TourPackageType.MEDICAL;
    }
    public MedicalTourPackage(String foodSystem, String transport, int numberOfDays, int price) {
        super(foodSystem, transport, numberOfDays, price);

    }
}
