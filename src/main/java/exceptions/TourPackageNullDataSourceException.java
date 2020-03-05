package exceptions;

public class TourPackageNullDataSourceException extends Exception {
    private static String message = "Data source can't be null";

    public TourPackageNullDataSourceException() {
        super(message);
    }
}
