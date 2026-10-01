package level_3.exercise_1_cinema_reserves;

import java.util.Objects;

public class Seat {
    private final int row;
    private final int col;
    private String personName;

    public Seat(int col, int row) {
        this.col = col;
        this.row = row;
        personName = "";
    }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) {
        if (personName == null)
                throw new IllegalArgumentException("Person name cannot be null");

        this.personName = personName;
    }
    public void clearSeat() { personName = ""; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Seat seat1)) return false;
        return row == seat1.row && col == seat1.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "\nSeat{" +
                "row=" + row +
                ", seat=" + col +
                ", personName='" + personName + '\'' +
                '}';
    }
}
