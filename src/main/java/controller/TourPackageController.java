package controller;

import entity.*;
import exceptions.TourPackageNullRepositoryException;
import model.TourPackageRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TourPackageController {
    final static Logger logger = Logger.getLogger(TourPackageController.class);
    private TourPackageRepository tourPackageRepository;

    static {
        PropertyConfigurator.configure("./src/main/resources/log4j.properties");
    }

    public TourPackageController(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public List<TourPackage> createSortedListTourPackages(final String foodSystem, final String transport, final int numberOfDays, String typeTourPackage) throws TourPackageNullRepositoryException {

        logger.info("Start execution method");

        if(tourPackageRepository==null) {
            logger.error("Repository is null");
            throw new TourPackageNullRepositoryException("TourPackageRepository can't be null");
        }

        List<TourPackage> tours = (List<TourPackage>) tourPackageRepository.getTours();

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

    public TourPackageRepository getTourPackageRepository() {
        return tourPackageRepository;
    }

    public void setTourPackageRepository(TourPackageRepository tourPackageRepository) throws TourPackageNullRepositoryException {
        if(tourPackageRepository==null) {
            logger.error("Repository is null");
            throw new TourPackageNullRepositoryException("TourPackageRepository can't be null");
        }
        this.tourPackageRepository = tourPackageRepository;
    }
}
