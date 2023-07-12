import java.util.UUID;

public class Group {

    private final UUID id;

    private int number;

    public Group(int number) {
        this.id = UUID.randomUUID();
        this.number = setNumber(number);
    }

    public int setNumber(int number) {
        if (number > 0) {
            return number;
        } else {
            throw new IllegalArgumentException("Номер группы не может быть отрицательным!");
        }
    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id.equals(group.id);
    }

    @Override
    public String toString() {
        return "Группа {" + id + "}, номер: " + number + "\n";
    }
}
