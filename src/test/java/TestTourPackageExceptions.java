import controller.TourPackageController;
import exceptions.TourPackageNullRepositoryException;
import org.junit.Assert;
import org.junit.Test;
import utils.TourPackageRepositoryMock;

public class TestTourPackageExceptions {
    @Test
    public void testNullRepositoryException(){
        TourPackageController tourPackageController =new TourPackageController(null);
        try {
            tourPackageController.createSortedListTourPackages("","",0,"");
            Assert.fail("Expected TourPackageNullRepositoryException");
        } catch (TourPackageNullRepositoryException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}
