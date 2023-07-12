import java.util.List;

public class StudentPresenter {

    private final GroupModel groupModel;

    private final StudentModel studentModel;

    public StudentPresenter(GroupModel groupModel, StudentModel studentModel) {
        this.groupModel = groupModel;
        this.studentModel = studentModel;
    }

    public void create(String name, String groupNumber) {
        Group group = groupModel.getByNumber(Integer.parseInt(groupNumber));
        if (group != null) {
            studentModel.create(name, group);
        }
    }

    public List<Student> getByGroup(String groupNumber) {
        Group group = groupModel.getByNumber(Integer.parseInt(groupNumber));
        if (group != null) {
            return studentModel.getByGroup(group);
        }
        return List.of();
    }
}
