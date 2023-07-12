import java.util.*;

public class LessonModel {

    private List<Lesson> lessons = new ArrayList<>();

    public void create(Date date) {
        lessons.add(new Lesson(date));
    }

    public List<Lesson> getAll() {
        return List.copyOf(lessons);
    }

    public void addGroup(Lesson lesson, Group group) {
        lesson.addGroup(group);
    }

    public List<Lesson> getByGroup(Group group) {
        return lessons.stream()
                .filter(it -> it.getGroups().contains(group))
                .toList();
    }

    public Lesson getById(UUID id) {
        return lessons.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

}
