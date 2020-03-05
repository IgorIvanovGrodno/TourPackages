package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.domain.*;
import model.DAO.DataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataSourceMock implements DataSource {
    private static List<TourPackage> tours;

    static {
        StringBuilder jsonArrayShoppingTourPackage = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/test/resources/TestTourPackageListData"))) {
            while (bufferedReader.ready()) {
                jsonArrayShoppingTourPackage.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonArrayShoppingTourPackage.length() > 0) {
            //Create custom deserializer for deserialization List of Polymorphic Objects
            TourPackageDeserializer deserializer = new TourPackageDeserializer("type");
            //Add types for mapping
            deserializer.registerBarnType("SHOPPING", ShoppingTourPackage.class);
            deserializer.registerBarnType("CRUISE", CruiseTourPackage.class);
            deserializer.registerBarnType("RELAXATION", RelaxationTourPackage.class);
            deserializer.registerBarnType("MEDICAL", MedicalTourPackage.class);
            deserializer.registerBarnType("EXCURSION", ExcursionTourPackage.class);
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(TourPackage.class, deserializer)
                    .create();
            tours = gson.fromJson(jsonArrayShoppingTourPackage.toString(), new TypeToken<List<TourPackage>>() {
            }.getType());


        }

    }

    public List<TourPackage> getTourPackages() {
        return tours;
    }
}
