import controller.TourPackageController;
import exceptions.TourPackageNullDAOException;
import model.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static utils.TourPackageControllerBuilder.getTourPackageController;

public class TestTourPackageController {
    @Test
    public void testSelectFoodSystem(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("all", "", 0, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }
    @Test
    public void testSelectNoExistingFoodSystem(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("qwerty", "", 0, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }

    @Test
    public void testSelectTransport(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "airplane", 0, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3,sizeActual);
    }

    @Test
    public void testSelectNoExistingTransport(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "qwerty", 0, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }

    @Test
    public void testSelectNumberOfDays(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 7, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,sizeActual);
    }
    @Test
    public void testSelectNoExistingNumberOfDays(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 365, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }
    @Test
    public void testNullParams(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages(null, null, -1, null).size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }

    @Test
    public void testEmptyParams(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 0, "").size();
        } catch (TourPackageNullDAOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }

    @Test
    public void testSortedAllTourPackages(){
        List<TourPackage> actualList = null;
        try {
            actualList = getTourPackageController().createSortedListTourPackages("", "", 0, "");
        } catch (TourPackageNullDAOException e) {
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

    @Test(expected = TourPackageNullDAOException.class)
    public void testNullDAOException() throws TourPackageNullDAOException {
        TourPackageController tourPackageController =new TourPackageController(null);
        tourPackageController.createSortedListTourPackages("","",0,"");
    }

    @Test(expected = TourPackageNullDAOException.class)
    public void testSetNullDAOException() throws TourPackageNullDAOException {
        getTourPackageController().setTourPackageDAO(null);
    }

}
