import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class To_Do_List {

    static Scanner sc = new Scanner(System.in);

    public ArrayList<Task> tasks;
    int taskcounter = 0;
    
    public To_Do_List() {
        tasks = new ArrayList<>();
    }

    public static void main(String[] args) {

        To_Do_List toDoList = new To_Do_List();
        int opt = 0;

        do {
            System.out.println("Enter option (1: Add Task, 2: Get Task Status, 3: Display All Tasks, 4: Edit Task, 5: Exit):");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    toDoList.addTask();
                    break;

                case 2:
                    System.out.println("Enter Task ID:");
                    int tempid = sc.nextInt();
                    sc.nextLine();
                    String status = toDoList.gettaskstatus(tempid);
                    System.out.println("Task Status: " + status);
                    break;

                case 3:
                    toDoList.displayalltask();
                    break;

                case 4:
                    System.out.println("Enter Task Id To Be Edited:");
                    int tempid2 = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Task:");
                    String newtask = sc.nextLine();

                    toDoList.rewrite_task(tempid2, newtask);
                    break;

                default:
                    break;
            }
        } while (opt != 5);
    }

    public void addTask() {
        String description;
        String status;
        LocalDate current_date;
        LocalDate due_date;

        taskcounter++;

        System.out.println("Enter Task:");
        description = sc.nextLine();

        System.out.println("Enter Task Due Date:");

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = sc.nextInt();
        sc.nextLine();

        due_date = LocalDate.of(year, month, day);
        current_date = LocalDate.now();
        status = "Ongoing";

        Task newTask = new Task(taskcounter, description, status, current_date, due_date);
        tasks.add(newTask);

        System.out.println("Task Added");
    }

    public String gettaskstatus(int tempid) {
        for (Task current : tasks) {
            if (current.gettaskid() == tempid) {
                return current.getStatus();
            }
        }
        return "Task not found";
    }

    public void removetask(int tempid) {
        if (tasks.isEmpty()) {
            System.out.println("Tasks List Is Empty!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task current = tasks.get(i);
            if (current.gettaskid() == tempid) {
                tasks.remove(i);
                System.out.println("Task with ID " + tempid + " has been removed.");

                for (int j = 0; j < tasks.size(); j++) {
                    tasks.get(j).settaskid(j + 1);
                }
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void rewrite_task(int tempid, String newtask) {
        for (Task temp : tasks) {
            if (temp.gettaskid() == tempid) {
                temp.setDescription(newtask);
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("No Task Found With That Id!");
    }

    public void displayalltask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task temp : tasks) {
            System.out.println("Task ID: " + temp.gettaskid());
            System.out.println("Status: " + temp.getStatus());
            System.out.println("Created On: " + temp.getCurrent_date());
            System.out.println("Description: [" + temp.getDescription() + "]");
            System.out.println("Due Date: " + temp.getDue_date());
            System.out.println();
        }
    }
}
