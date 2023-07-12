import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LessonPresenter {
    private final View view;
    private final LessonModel lessonModel;

    private final GroupModel groupModel;

    private final StudentModel studentModel;

    public LessonPresenter(View view, LessonModel lessonModel, GroupModel groupModel, StudentModel studentModel) {
        this.view = view;
        this.lessonModel = lessonModel;
        this.groupModel = groupModel;
        this.studentModel = studentModel;
    }

    public void create(Date date) {
        lessonModel.create(date);
    }

    public void getAll() {
        List<Lesson> lessons = lessonModel.getAll();
        view.printAllLessons(lessons);
    }

    public void addGroup(String id, String groupNumber) {
        Lesson lesson = lessonModel.getById(UUID.fromString(id));
        Group group = groupModel.getByNumber(Integer.parseInt(groupNumber));
        if (lesson != null && group != null) {
            lessonModel.addGroup(lesson, group);
        }
    }

    public void getLessons(String studentId) {
        Student student = studentModel.getById(UUID.fromString(studentId));
        Group group = student.getGroup();
        List<Lesson> lessons = lessonModel.getByGroup(group);
        view.printAllLessons(lessons);
    }
}
