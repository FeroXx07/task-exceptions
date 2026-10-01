package level_3.exercise_1_cinema_reserves;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConsoleUI {
    private ReservationService reservationService;
    private static final Logger LOGGER = LogManager.getLogger();
    public ConsoleUI(ReservationService reservationService) {
        if (reservationService == null) {
            throw new IllegalArgumentException("ReservationService cannot be null");
        }
        this.reservationService = reservationService;
    }

    public void Start(){
        boolean exit = false;
        do {
            try {
                switch (inputMainMenu()){
                    case 0:{
                        LOGGER.info("Thanks for using our application!");
                        exit = true;
                        break;
                    }
                    case 1:
                        handleGetAll();
                        break;
                    case 2:
                        handleGetAllByPerson();
                        break;
                    case 3:
                        handleReservation();
                        break;
                    case 4:
                        handleCancellation();
                        break;
                    case 5:
                        handleCancellationAllByPerson();
                        break;
                }
            }
            catch (Exception e) {
                LOGGER.warn("{}. {}", e.getClass().getSimpleName(), e.getMessage());
            }
        }while(!exit);
    }

    private byte inputMainMenu() {
        byte option;
        final byte MINIM = 0;
        final byte MAXIM = 5;

        do {
            LOGGER.info("\nMAIN MENU");
            LOGGER.info("Option 1: Get all Seats");
            LOGGER.info("Option 2: Get all Seats of Person");
            LOGGER.info("Option 3: Reserve a Seat");
            LOGGER.info("Option 4: Cancel a Seat");
            LOGGER.info("Option 5: Cancel all Seats of Person");
            LOGGER.info("Option 0: Exit App");
            option = ScannerUtility.fetchNumber( "Select an option: ", byte.class);
            if (option < MINIM || option > MAXIM) {
                LOGGER.info("Select a valid option!");
            }
        } while (option < MINIM || option > MAXIM);
        return option;
    }

    private void handleGetAll() {
        List<Seat> list = reservationService.getAllSeats();
        LOGGER.info("Number of Seats of in total: {}", list.size());
        LOGGER.info(list);
    }

    private void handleGetAllByPerson() {
        String personName = ScannerUtility.fetchStringInput("Enter the name of the person: ");
        List<Seat> list = reservationService.getSeatsByPerson(personName);
        LOGGER.info("Number of Seats of in total for this person: {}", list.size());
        LOGGER.info(list);
    }

    private void handleReservation() {
        byte row = ScannerUtility.fetchNumber("Enter the row of the seat to reserve:", byte.class);
        byte col = ScannerUtility.fetchNumber("Enter the column of the seat to reserve:", byte.class);
        String personName = ScannerUtility.fetchStringInput("Enter the name of the person: ");
        reservationService.reserveSeat(row, col, personName);
        LOGGER.info("Reservation has been successful!");
    }

    private void handleCancellation() {
        byte row = ScannerUtility.fetchNumber("Enter the row of the seat to cancel:", byte.class);
        byte col = ScannerUtility.fetchNumber("Enter the column of the seat to cancel:", byte.class);
        reservationService.cancelSeat(row, col);
        LOGGER.info("Cancellation has been successful!");
    }

    private void handleCancellationAllByPerson() {
        String personName = ScannerUtility.fetchStringInput("Enter the name of the person: ");
        reservationService.cancelAllByPerson(personName);
        LOGGER.info("Cancellations have been successful!");
    }


}
