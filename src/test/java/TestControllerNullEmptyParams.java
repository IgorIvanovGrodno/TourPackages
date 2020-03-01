import exceptions.TourPackageNullRepositoryException;
import org.junit.Assert;
import org.junit.Test;


import static utils.TourPackageControllerBuilder.getTourPackageController;

public class TestControllerNullEmptyParams {

    @Test
    public void testNullParams(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages(null, null, -1, null).size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }

    @Test
    public void testEmptyParams(){
        int sizeActual = 0;
        try {
            sizeActual = getTourPackageController().createSortedListTourPackages("", "", 0, "").size();
        } catch (TourPackageNullRepositoryException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(10,sizeActual);
    }


}
