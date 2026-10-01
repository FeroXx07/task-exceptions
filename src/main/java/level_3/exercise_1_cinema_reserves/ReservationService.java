package level_3.exercise_1_cinema_reserves;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private final int totalRows; // max Y
    private final int seatsPerRow; // max X
    private List<Seat> seats;

    public ReservationService(int totalRows, int seatsPerRow) {
        if (totalRows <= 0 || seatsPerRow <= 0) {
            throw new IllegalArgumentException("Number of rows and seats per row must be greater than 0");
        }
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        seats = initializeSeats();
    }

    public void reserveSeat(int row, int col, String name) {
        validatePersonName(name);
        Seat seat = getSeat(row, col);
        validateSeatNotTaken(seat);
        seat.setPersonName(name);
    }

    public void cancelSeat(int row, int col) {
        Seat seat = getSeat(row, col);
        validateSeatTaken(seat);
        seat.clearSeat();
    }

    public void cancelAllByPerson(String person) {
        List<Seat> seats = getSeatsByPerson(person);

        for (Seat seat : seats) {
            validateSeatTaken(seat);
            seat.clearSeat();
        }
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(seats);
    }

    public List<Seat> getSeatsByPerson(String person) {
        validatePersonName(person);

        var list = seats
                .stream()
                .filter(seat -> seat.getPersonName().equalsIgnoreCase(person))
                .toList();

        if (list.isEmpty()) {
            throw new SeatAlreadyEmptyException ("Person doesn't have any seats!");
        }

        return list;
    }

    private ArrayList<Seat> initializeSeats() {
        int size = seatsPerRow * totalRows;
        ArrayList<Seat> seats = new ArrayList<>(size);
        for (int y = 1; y <= totalRows; y++) {
            for (int x = 1; x <= seatsPerRow; x++) {
                seats.add(new Seat(x, y));
            }
        }
        return seats;
    }

    private int toOneDimensionalIndex(int x, int y) {
        return y * seatsPerRow + x;
    }

    private void validateSeatPosition(int row, int col){
        if (row < 1 || row > totalRows || col < 1 || col > seatsPerRow) {
            throw new InvalidSeatException ("Seat position is out of bounds");
        }
    }

    private void validatePersonName(String personName) {
        if (personName == null || personName.isBlank()) {
            throw new InvalidPersonNameException ("Person name is null or empty");
        }
    }

    private void validateSeatNotTaken(Seat seat) {
        if (!seat.getPersonName().isBlank()){
            throw new SeatAlreadyTakenException("Seat is already taken");
        }
    }
    private void validateSeatTaken(Seat seat) {
        if (seat.getPersonName().isBlank()){
            throw new SeatAlreadyEmptyException("Seat is already empty");
        }
    }
    private Seat getSeat(int row, int col) {
        validateSeatPosition(row, col);

        int x = col -1;
        int y = row - 1;
        int index = toOneDimensionalIndex(x, y);

        return seats.get(index);
    }
}
