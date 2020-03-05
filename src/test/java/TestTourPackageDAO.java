import model.DAO.TourPackageDAO;
import exceptions.TourPackageNullDataSourceException;
import model.domain.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.DataSourceMock;

import java.util.Arrays;
import java.util.List;

public class TestTourPackageDAO {
    private static TourPackageDAO tourPackageDAO;

    @BeforeClass
    public static void setUp() {
        tourPackageDAO = new TourPackageDAO(new DataSourceMock());
    }

    @Test
    public void shouldReturnListTourPackagesExpectedSize_whenSelectFoodSystem() throws TourPackageNullDataSourceException {

        int sizeActual = tourPackageDAO.selectTourPackages("all", "", 0, null).size();

        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void shouldReturnEmptyList_whenSelectNoExistingFoodSystem() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("qwerty", "", 0, null).size();
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void shouldReturnListTourPackagesExpectedSize_whenSelectTransport() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("", "airplane", 0, null).size();
        Assert.assertEquals(3, sizeActual);
    }

    @Test
    public void shouldReturnEmptyList_whenSelectNoExistingTransport() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("", "qwerty", 0, null).size();
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void shouldReturnListTourPackagesExpectedSize_whenSelectNumberOfDays() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("", "", 7, null).size();
        Assert.assertEquals(2, sizeActual);
    }

    @Test
    public void shouldReturnEmptyList_whenSelectNoExistingNumberOfDays() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("", "", 365, null).size();
        Assert.assertEquals(0, sizeActual);
    }

    @Test
    public void shouldReturnSortedListOfCruiseTourPackages_whenSelectCruiseType() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, TourPackageType.CRUISE);
        List<CruiseTourPackage> expectedList = Arrays.asList(
                new CruiseTourPackage("all", "ship", 10, 100),
                new CruiseTourPackage("all", "ship", 10, 500));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void shouldReturnSortedListOfShoppingTourPackages_whenSelectShoppingType() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, TourPackageType.SHOPPING);
        List<ShoppingTourPackage> expectedList = Arrays.asList(
                new ShoppingTourPackage("all", "bus", 10, 200),
                new ShoppingTourPackage("all", "bus", 5, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void shouldReturnSortedListOfExcursionTourPackages_whenSelectExcursionType() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, TourPackageType.EXCURSION);
        List<ExcursionTourPackage> expectedList = Arrays.asList(
                new ExcursionTourPackage("all", "train", 5, 100),
                new ExcursionTourPackage("all", "bus", 7, 300));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void shouldReturnSortedListOfMedicalTourPackages_whenSelectMedicalType() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, TourPackageType.MEDICAL);
        List<MedicalTourPackage> expectedList = Arrays.asList(
                new MedicalTourPackage("all", "train", 30, 900),
                new MedicalTourPackage("all", "airplane", 30, 1000));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void shouldReturnSortedListOfRelaxationTourPackages_whenSelectRelaxationType() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, TourPackageType.RELAXATION);
        List<RelaxationTourPackage> expectedList = Arrays.asList(
                new RelaxationTourPackage("all", "airplane", 7, 600),
                new RelaxationTourPackage("all", "airplane", 15, 800));
        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});
    }

    @Test
    public void shouldReturnAllTourPackages_whenSelectNullParams() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages(null, null, -1, null).size();
        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void shouldReturnAllTourPackages_whenSelectEmptyParams() throws TourPackageNullDataSourceException {
        int sizeActual = tourPackageDAO.selectTourPackages("", "", 0, null).size();
        Assert.assertEquals(10, sizeActual);
    }

    @Test
    public void shouldReturnSortedAllTourPackages_whenSelectAllTourPackages() throws TourPackageNullDataSourceException {
        List<TourPackage> actualList = tourPackageDAO.selectTourPackages("", "", 0, null);
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

    @Test(expected = TourPackageNullDataSourceException.class)
    public void shouldThrowNullDAOException_whenPassNullToConstructorOfTourPackageDAO() throws TourPackageNullDataSourceException {
        TourPackageDAO tourPackageDAO = new TourPackageDAO(null);
        tourPackageDAO.selectTourPackages("", "", 0, null);
    }

    @Test(expected = TourPackageNullDataSourceException.class)
    public void shouldThrowNullDAOException_whenPassNullToSetDataSourceMethodOfTourPackageDAO() throws TourPackageNullDataSourceException {
        tourPackageDAO.setDataSource(null);
    }

}
