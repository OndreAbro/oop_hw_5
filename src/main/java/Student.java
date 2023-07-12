import java.util.UUID;

public class Student {

    private final UUID id;

    private final String name;

    private final Group group;


    public Student(String name, Group group) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.group = group;
    }

    public UUID getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public String toString() {
        return name + ", id: {" + id + "}, группа: " + group.getNumber() + "\n";
    }
}
