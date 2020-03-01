package utils;

import controller.TourPackageController;

public class TourPackageControllerBuilder {
    static private TourPackageController tourPackageController = new TourPackageController(new TourPackageRepositoryMock());

    public static TourPackageController getTourPackageController() {
        return tourPackageController;
    }
}
