package model.DAO;

import exceptions.TourPackageNullDataSourceException;
import model.domain.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TourPackageDAO {
    final static Logger logger = Logger.getLogger(TourPackageDAO.class);
    private DataSource dataSource;

    static {
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }

    public TourPackageDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<TourPackage> selectTourPackages(final String foodSystem, final String transport, final int numberOfDays, TourPackageType typeTourPackage) throws TourPackageNullDataSourceException {

        logger.debug("Start execution method with params: foodSystem=" + foodSystem + " transport=" + transport + " numberOfDays=" + numberOfDays + " typeTourPackage=" + typeTourPackage);

        if (dataSource == null) {
            logger.error("Data source is null. StackTrace: "+Arrays.stream(Thread.currentThread().getStackTrace()).collect(Collectors.toList()));
            throw new TourPackageNullDataSourceException();
        }

        List<TourPackage> tours = dataSource.getTourPackages();

        if (typeTourPackage != null) {
            tours = tours.stream().filter((s) -> s.getType().equals(typeTourPackage)).collect(Collectors.toList());
        }

        if (foodSystem != null && !foodSystem.isEmpty()) {
            tours = tours.stream().filter((s) -> s.getFoodSystem().equals(foodSystem)).collect(Collectors.toList());
        }

        if (transport != null && !transport.isEmpty()) {
            tours = tours.stream().filter((s) -> s.getTransport().equals(transport)).collect(Collectors.toList());
        }

        if (numberOfDays > 0) {
            tours = tours.stream().filter((s) -> s.getNumberOfDays() == numberOfDays).collect(Collectors.toList());
        }

        List<TourPackage> resultList = sortListTourPackages(tours);
        logger.debug("End execution method with result: " + resultList);
        return resultList;

    }

    private List<TourPackage> sortListTourPackages(List<TourPackage> listTourPackages) {
        return listTourPackages.stream().sorted().collect(Collectors.toList());
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) throws TourPackageNullDataSourceException {
        if (dataSource == null) {
            logger.error("Data source is null. StackTrace: "+ Arrays.stream(Thread.currentThread().getStackTrace()).collect(Collectors.toList()));
            throw new TourPackageNullDataSourceException();
        }
        this.dataSource = dataSource;
    }
}
