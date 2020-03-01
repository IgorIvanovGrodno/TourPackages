import entity.*;
import exceptions.TourPackageNullRepositoryException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static utils.TourPackageControllerBuilder.getTourPackageController;

public class TestControllerSort {
    @Test
    public void testSortedAllTourPackages(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "", 0, "");
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        List<TourPackage> expectedList= Arrays.asList(
                new CruiseTourPackage("all", "ship",10, 100),
                new CruiseTourPackage("all", "ship",10, 500),
                new ExcursionTourPackage("all", "train", 5, 100),
                new ExcursionTourPackage("all", "bus", 7, 300),
                new MedicalTourPackage("all", "train", 30, 900),
                new MedicalTourPackage("all", "airplane", 30, 1000),
                new RelaxationTourPackage("all", "airplane", 7, 600),
                new RelaxationTourPackage("all", "airplane", 15, 800),
                new ShoppingTourPackage("all", "bus",10, 200),
                new ShoppingTourPackage("all", "bus",5, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }
}
