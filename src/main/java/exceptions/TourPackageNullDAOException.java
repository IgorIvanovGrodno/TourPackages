package exceptions;

public class TourPackageNullDAOException extends Exception {
    private static String message = "TourPackageDAO can't be null";

    public TourPackageNullDAOException() {
        super(message);
    }
}
