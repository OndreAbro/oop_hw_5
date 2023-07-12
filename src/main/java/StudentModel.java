import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StudentModel {
    private List<Student> students = new ArrayList<>();

    public void create(String name, Group group) {
        students.add(new Student(name, group));
    }

    public List<Student> getByGroup(Group group) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroup(), group))
                .toList();
    }

    public Student getById(UUID id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }
}
