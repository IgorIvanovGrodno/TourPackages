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

    public List<TourPackage> createSortedListTourPackages(final String foodSystem, final String transport, final int numberOfDays, String typeTourPackage) throws TourPackageNullDAOException {

        logger.info("Start execution method");

        if(tourPackageDAO ==null) {
            logger.error("TourPackageDAO is null");
            throw new TourPackageNullDAOException();
        }

        List<TourPackage> tours = (List<TourPackage>) tourPackageDAO.getTourPackages();

        if(typeTourPackage!=null&&!typeTourPackage.isEmpty()) {
            switch (typeTourPackage.toLowerCase()) {
                case "cruise":
                    tours = tours.stream().filter((s) -> s instanceof CruiseTourPackage).collect(Collectors.toList());
                    break;
                case "shopping":
                    tours = tours.stream().filter((s) -> s instanceof ShoppingTourPackage).collect(Collectors.toList());
                    break;
                case "relaxation":
                    tours = tours.stream().filter((s) -> s instanceof RelaxationTourPackage).collect(Collectors.toList());
                    break;
                case "medical":
                    tours = tours.stream().filter((s) -> s instanceof MedicalTourPackage).collect(Collectors.toList());
                    break;
                case "excursion":
                    tours = tours.stream().filter((s) -> s instanceof ExcursionTourPackage).collect(Collectors.toList());
                    break;
                default: tours = new ArrayList<>();
            }
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
