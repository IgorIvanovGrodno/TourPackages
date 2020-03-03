package controller;

import exceptions.TourPackageNullDAOException;
import model.domain.*;
import model.DAO.TourPackageDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TourPackageController {
    final static Logger logger = Logger.getLogger(TourPackageController.class);
    private TourPackageDAO tourPackageDAO;

    static {
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }

    public TourPackageController(TourPackageDAO tourPackageDAO) {
        this.tourPackageDAO = tourPackageDAO;
    }

    public List<TourPackage> createSortedListTourPackages(final String foodSystem, final String transport, final int numberOfDays, TourPackageType typeTourPackage) throws TourPackageNullDAOException {

        logger.info("Start execution method");

        if(tourPackageDAO ==null) {
            logger.error("TourPackageDAO is null");
            throw new TourPackageNullDAOException();
        }

        List<TourPackage> tours = (List<TourPackage>) tourPackageDAO.getTourPackages();

        if(typeTourPackage!=null) {
            tours=tours.stream().filter((s)->s.getType().equals(typeTourPackage)).collect(Collectors.toList());
        }

        if(foodSystem!=null&&!foodSystem.isEmpty()) {
            tours=tours.stream().filter((s)->s.getFoodSystem().equals(foodSystem)).collect(Collectors.toList());
        }

        if(transport!=null&&!transport.isEmpty()){
            tours=tours.stream().filter((s)->s.getTransport().equals(transport)).collect(Collectors.toList());
        }

        if(numberOfDays>0){
            tours=tours.stream().filter((s)->s.getNumberOfDays()==numberOfDays).collect(Collectors.toList());
        }

        logger.info("End execution method");
        return tours.stream().sorted().collect(Collectors.toList());

    }

    public TourPackageDAO getTourPackageDAO() {
        return tourPackageDAO;
    }

    public void setTourPackageDAO(TourPackageDAO tourPackageDAO) throws TourPackageNullDAOException {
        if(tourPackageDAO ==null) {
            logger.error("TourPackageDAO is null");
            throw new TourPackageNullDAOException();
        }
        this.tourPackageDAO = tourPackageDAO;
    }
}
