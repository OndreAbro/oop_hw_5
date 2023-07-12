import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {

    private GroupPresenter groupPresenter;
    private StudentPresenter studentPresenter;
    private LessonPresenter lessonPresenter;

    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void setGroupPresenter(GroupPresenter groupPresenter) {
        this.groupPresenter = groupPresenter;
    }

    public void setStudentPresenter(StudentPresenter studentPresenter) {
        this.studentPresenter = studentPresenter;
    }

    public void setLessonPresenter(LessonPresenter lessonPresenter) {
        this.lessonPresenter = lessonPresenter;
    }

    public void start() {
        while (true) {
            System.out.println("""
                    Список доступных команд:
                    1. group create {number}
                    2. group list
                    3. student create {name} {groupNumber}
                    4. student list {groupNumber}
                    5. lesson create {date}
                    6. lesson list
                    7. lesson add {lessonId} {groupNumber}
                    8. lesson list {studentId}
                    9. exit
                    """);
            String command = scanner.nextLine();

            if ("exit".equals(command)) {
                break;
            }

            String[] commandArray = command.split(" ");
            String commandName = commandArray[0];
            String[] args = Arrays.copyOfRange(commandArray, 1, commandArray.length);

            if ("group".equals(commandName)) {
                handleGroupCommand(args);
            } else if ("student".equals(commandName)) {
                handleStudentCommand(args);
            } else if ("lesson".equals(commandName)) {
                handleLessonCommand(args);
            } else {
                System.out.println("Неверный ввод команды!");
            }
        }
    }

    public void printAllGroups(List<Group> groups) {
        System.out.println(groups);
    }

    public void printAllLessons(List<Lesson> lessons) {
        System.out.println(lessons);
    }

    private void handleGroupCommand(String[] args) {
        if (args.length == 2 && "create".equals(args[0])) {
            groupPresenter.create(args[1]);
        } else if (args.length == 1 && "list".equals(args[0])) {
            groupPresenter.getAll();
        } else {
            System.err.println("Неизвестная команда");
        }
    }

    private void handleStudentCommand(String[] args) {
        if (args.length == 2 && "list".equals(args[0])) {
            System.out.println(studentPresenter.getByGroup(args[1]));
        } else if (args.length == 3 && "create".equals(args[0])) {
            studentPresenter.create(args[1], args[2]);
        } else {
            System.err.println("Неизвестная команда");
        }
    }

    private void handleLessonCommand(String[] args) {
        if (args.length == 2 && "create".equals(args[0])) {
            try {
                Date parseDate = new SimpleDateFormat("dd.MM.yyyy").parse(args[1]);
                lessonPresenter.create(parseDate);
            } catch (ParseException e) {
                System.out.println("Неверный ввод даты!");
            }
        } else if (args.length == 1 && "list".equals(args[0])) {
            lessonPresenter.getAll();
        } else if (args.length == 3 && "add".equals(args[0])) {
            lessonPresenter.addGroup(args[1], args[2]);
        } else if (args.length == 2 && "list".equals(args[0])) {
            lessonPresenter.getLessons(args[1]);
        } else {
            System.err.println("Неизвестная команда");
        }
    }

}

