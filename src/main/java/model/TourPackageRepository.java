package model;

import entity.TourPackage;

import java.util.Collection;

public interface TourPackageRepository {
    Collection<TourPackage> getTours();
}
