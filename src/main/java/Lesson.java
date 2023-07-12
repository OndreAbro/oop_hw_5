import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;


public class Lesson {

    private final UUID id;

    private List<Group> groups = new ArrayList<>();

    private final Date date;

    public Lesson(Date date) {
        this.id = UUID.randomUUID();
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public List<Group> getGroups() {
        return List.copyOf(groups);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Урок {" + id + "}, дата: " +
                new SimpleDateFormat("EEE, d MMM yyyy").format(date) +
                ", группы: " + groups + "\n";
    }

}

