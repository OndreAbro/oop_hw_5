public class Homework {

    /**
     * Разработать свое MVP приложение со следующей моделью данных:
     * 1. Группа студентов (идентификатор, номер)
     * 2. Студент (идентификатор, имя, группа)
     * Реализовать стандартные операции:
     * - создание группы
     * - просмотр всех групп
     * - создание студента в группе
     * - просмотр всех студентов одной группы
     * <p>
     * 3*. Реализовать новую сущность Урок (идентификатор, группа, дата).
     * - создание урока для групп
     * - просмотр всех уроков у студента
     * <p>
     * lesson <-> studentGroup <- student
     */

    public static void main(String[] args) {
        GroupModel groupModel = new GroupModel();
        StudentModel studentModel = new StudentModel();
        LessonModel lessonModel = new LessonModel();

        View view = new View();

        GroupPresenter groupPresenter = new GroupPresenter(view, groupModel);
        StudentPresenter studentPresenter = new StudentPresenter(groupModel, studentModel);
        LessonPresenter lessonPresenter = new LessonPresenter(view, lessonModel, groupModel, studentModel);

        view.setGroupPresenter(groupPresenter);
        view.setStudentPresenter(studentPresenter);
        view.setLessonPresenter(lessonPresenter);

        view.start();

    }
}
