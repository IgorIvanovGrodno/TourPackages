package utils;

import controller.TourPackageController;

public class TourPackageControllerBuilder {
    static private TourPackageController tourPackageController = new TourPackageController(new TourPackageDAOMock());

    public static TourPackageController getTourPackageController() {
        return tourPackageController;
    }
}
