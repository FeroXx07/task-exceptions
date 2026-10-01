package level_3.exercise_1_cinema_reserves;

import java.util.Objects;

public class Seat {
    private int row;
    private int seat;
    private String personName;

    public Seat(int seat, int row, String personName) {
        this.seat = seat;
        this.row = row;
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Seat seat1)) return false;
        return row == seat1.row && seat == seat1.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", seat=" + seat +
                ", personName='" + personName + '\'' +
                '}';
    }
}
