package utils;

import com.google.gson.*;
import model.domain.TourPackage;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TourPackageDeserializer  implements JsonDeserializer<TourPackage> {
    //The name of the field in the JSON file, which is used to determine the type of object
    private String tourPackageTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends TourPackage>> tourPackageTypeRegistry;

    public TourPackageDeserializer(String tourPackageTypeElementName) {
        this.tourPackageTypeElementName = tourPackageTypeElementName;
        this.gson = new Gson();
        this.tourPackageTypeRegistry = new HashMap<>();
    }

    //Mapping types of objects and value in the JSON file
    public void registerBarnType(String tourPackageTypeName, Class<? extends TourPackage> tourPackageType) {
        tourPackageTypeRegistry.put(tourPackageTypeName, tourPackageType);
    }


    public TourPackage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject tourPackageObject = json.getAsJsonObject();
        JsonElement tourPackageTypeElement = tourPackageObject.get(tourPackageTypeElementName);

        Class<? extends TourPackage> tourPackageType = tourPackageTypeRegistry.get(tourPackageTypeElement.getAsString());
        return gson.fromJson(tourPackageObject, tourPackageType);
    }
}
