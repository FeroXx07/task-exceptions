package level_3.exercise_1_cinema_reserves;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    void main(String[] args) {
        LOGGER.info("Init Program");
        byte rows = ScannerUtility.fetchNumber("Enter how many rows in the theater?: ", Byte.class);
        byte cols = ScannerUtility.fetchNumber("Enter how many seats per row in the theater?: ", Byte.class);
        try {
            ReservationService reservationService = new ReservationService(rows, cols);
            ConsoleUI consoleUI = new ConsoleUI(reservationService);
            consoleUI.Start();
        }catch (Exception e) {
            LOGGER.fatal("A fatal exception occurred. {}, {}", e.getClass().getSimpleName(), e.getMessage());
        }
        LOGGER.info("End of Program");
    }
}
