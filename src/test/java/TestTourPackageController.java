import controller.TourPackageController;
import exceptions.TourPackageNullDAOException;
import model.domain.*;
import org.junit.Assert;
import org.junit.Test;
import utils.TourPackageDAOMock;

import java.util.Arrays;
import java.util.List;

public class TestTourPackageController {
    private TourPackageController tourPackageController = new TourPackageController(new TourPackageDAOMock());

    @Test
    public void testSelectFoodSystem() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("all", "", 0, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void testSelectNoExistingFoodSystem() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("qwerty", "", 0, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void testSelectTransport() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("", "airplane", 0, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3, sizeActual);
    }

    @Test
    public void testSelectNoExistingTransport() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("", "qwerty", 0, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void testSelectNumberOfDays() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("", "", 7, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, sizeActual);
    }

    @Test
    public void testSelectNoExistingNumberOfDays() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("", "", 365, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void testSelectCruiseType() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, TourPackageType.CRUISE);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<CruiseTourPackage> expectedList = Arrays.asList(
                new CruiseTourPackage("all", "ship", 10, 100),
                new CruiseTourPackage("all", "ship", 10, 500));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectShoppingType() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, TourPackageType.SHOPPING);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<ShoppingTourPackage> expectedList = Arrays.asList(
                new ShoppingTourPackage("all", "bus", 10, 200),
                new ShoppingTourPackage("all", "bus", 5, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectExcursionType() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, TourPackageType.EXCURSION);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<ExcursionTourPackage> expectedList = Arrays.asList(
                new ExcursionTourPackage("all", "train", 5, 100),
                new ExcursionTourPackage("all", "bus", 7, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectMedicalType() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, TourPackageType.MEDICAL);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<MedicalTourPackage> expectedList = Arrays.asList(
                new MedicalTourPackage("all", "train", 30, 900),
                new MedicalTourPackage("all", "airplane", 30, 1000));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testSelectRelaxationType() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, TourPackageType.RELAXATION);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<RelaxationTourPackage> expectedList = Arrays.asList(
                new RelaxationTourPackage("all", "airplane", 7, 600),
                new RelaxationTourPackage("all", "airplane", 15, 800));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void testNullParams() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages(null, null, -1, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void testEmptyParams() {
        int sizeActual = 0;
        try {
            sizeActual = tourPackageController.selectTourPackages("", "", 0, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void testSortedAllTourPackages() {
        List<TourPackage> actualList = null;
        try {
            actualList = tourPackageController.selectTourPackages("", "", 0, null);
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        List<TourPackage> expectedList = Arrays.asList(
                new CruiseTourPackage("all", "ship", 10, 100),
                new CruiseTourPackage("all", "ship", 10, 500),
                new ExcursionTourPackage("all", "train", 5, 100),
                new ExcursionTourPackage("all", "bus", 7, 300),
                new MedicalTourPackage("all", "train", 30, 900),
                new MedicalTourPackage("all", "airplane", 30, 1000),
                new RelaxationTourPackage("all", "airplane", 7, 600),
                new RelaxationTourPackage("all", "airplane", 15, 800),
                new ShoppingTourPackage("all", "bus", 10, 200),
                new ShoppingTourPackage("all", "bus", 5, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test(expected = TourPackageNullDAOException.class)
    public void testNullDAOException() throws TourPackageNullDAOException {
        TourPackageController tourPackageController = new TourPackageController(null);
        tourPackageController.selectTourPackages("", "", 0, null);
    }

    @Test(expected = TourPackageNullDAOException.class)
    public void testSetNullDAOException() throws TourPackageNullDAOException {
        tourPackageController.setTourPackageDAO(null);
    }

}
