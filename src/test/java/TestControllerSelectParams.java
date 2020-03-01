import exceptions.TourPackageNullRepositoryException;
import org.junit.Assert;
import org.junit.Test;

import static utils.TourPackageControllerBuilder.getTourPackageController;

public class TestControllerSelectParams {
    @Test
    public void testSelectFoodSystem(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("all", "", 0, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }
    @Test
    public void testSelectNoExistingFoodSystem(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("qwerty", "", 0, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }

    @Test
    public void testSelectTransport(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "airplane", 0, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3,sizeActual);
    }

    @Test
    public void testSelectNoExistingTransport(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "qwerty", 0, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }

    @Test
    public void testSelectNumberOfDays(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 7, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,sizeActual);
    }
    @Test
    public void testSelectNoExistingNumberOfDays(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 365, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,sizeActual);
    }
}
