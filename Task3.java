package cogni;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int id;
    private String title;
    private String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("[ID: %d] Title: %s | Description: %s", id, title, description);
    }
}

public class Task3 {
    private static final List<Task> taskList = new ArrayList<>();
    private static int nextId = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Task Manager (CRUD) ===");
            System.out.println("1. Create Task");
            System.out.println("2. Read / View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createTask();
                case 2 -> readTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting application.");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();

        taskList.add(new Task(nextId++, title, desc));
        System.out.println("Task added successfully!");
    }

    private static void readTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n--- Task List ---");
        for (Task t : taskList) {
            System.out.println(t);
        }
    }

    private static void updateTask() {
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task found = findTaskById(id);
        if (found == null) {
            System.out.println("Task not found with ID: " + id);
            return;
        }

        System.out.print("Enter new title (current: " + found.getTitle() + "): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description (current: " + found.getDescription() + "): ");
        String newDesc = scanner.nextLine();

        if (!newTitle.isBlank()) found.setTitle(newTitle);
        if (!newDesc.isBlank()) found.setDescription(newDesc);

        System.out.println("Task updated successfully!");
    }

    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task found = findTaskById(id);
        if (found == null) {
            System.out.println("Task not found with ID: " + id);
            return;
        }

        taskList.remove(found);
        System.out.println("Task deleted successfully!");
    }

    private static Task findTaskById(int id) {
        for (Task t : taskList) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}