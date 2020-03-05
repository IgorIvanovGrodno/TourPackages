package model.DAO;

import model.domain.TourPackage;

import java.util.List;

public interface DataSource {
    List<TourPackage> getTourPackages();
}
