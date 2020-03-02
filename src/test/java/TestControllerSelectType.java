import exceptions.TourPackageNullDAOException;
import model.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static utils.TourPackageControllerBuilder.getTourPackageController;

public class TestControllerSelectType {
    @Test
    public void testSelectCruiseType(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "",0, "cruise");
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<CruiseTourPackage> expectedList= Arrays.asList(
                new CruiseTourPackage("all", "ship",10, 100),
                new CruiseTourPackage("all", "ship",10, 500));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectShoppingType(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "",0, "shopping");
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<ShoppingTourPackage> expectedList= Arrays.asList(
                new ShoppingTourPackage("all", "bus",10, 200),
                new ShoppingTourPackage("all", "bus",5, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectExcursionType(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "",0, "excursion");
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<ExcursionTourPackage> expectedList= Arrays.asList(
                new ExcursionTourPackage("all", "train", 5, 100),
                new ExcursionTourPackage("all", "bus", 7, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectMedicalType(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "",0, "medical");
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<MedicalTourPackage> expectedList= Arrays.asList(
                new MedicalTourPackage("all", "train", 30, 900),
                new MedicalTourPackage("all", "airplane", 30, 1000));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectRelaxationType(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "",0, "relaxation");
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<RelaxationTourPackage> expectedList= Arrays.asList(
                new RelaxationTourPackage("all", "airplane", 7, 600),
                new RelaxationTourPackage("all", "airplane", 15, 800));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectNoExistingType(){
        int sizeActual = 0;
        try {
            sizeActual  = getTourPackageController().createSortedListTourPackages("all", "bus",7, "qwerty").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }
}
