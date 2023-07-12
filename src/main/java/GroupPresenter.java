import java.util.List;

public class GroupPresenter {

    private final View view;
    private final GroupModel model;

    public GroupPresenter(View view, GroupModel model) {
        this.view = view;
        this.model = model;
    }

    public void create(String groupNumber) {
        model.create(Integer.parseInt(groupNumber));
    }

    public void getAll() {
        List<Group> groups = model.getAll();
        view.printAllGroups(groups);
    }
}