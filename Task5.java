package cogni;
import java.io.*;
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

    // Format for file storage (CSV style: id,title,description)
    public String toCsvString() {
        return id + "," + title.replace(",", " ") + "," + description.replace(",", " ");
    }

    @Override
    public String toString() {
        return String.format("[ID: %d] Title: %s | Description: %s", id, title, description);
    }
}

public class Task5 {
    private static final String FILE_NAME = "tasks.txt";
    private static final List<Task> taskList = new ArrayList<>();
    private static int nextId = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasksFromFile();

        while (true) {
            System.out.println("\n=== Persistent Task Manager (Level 3) ===");
            System.out.println("1. Create Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting application.");
                    return;
                }
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    // 1. Create Task
    private static void createTask() {
        System.out.print("Enter Task Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Task Description: ");
        String desc = scanner.nextLine();

        Task task = new Task(nextId++, title, desc);
        taskList.add(task);
        saveTasksToFile();
        System.out.println("Task created and saved to file!");
    }

    // 2. Read / View Tasks
    private static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found in memory/file.");
            return;
        }
        System.out.println("\n--- Current Tasks ---");
        for (Task t : taskList) {
            System.out.println(t);
        }
    }

    // 3. Update Task
    private static void updateTask() {
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found with ID: " + id);
            return;
        }

        System.out.print("Enter new title (current: " + task.getTitle() + "): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description (current: " + task.getDescription() + "): ");
        String newDesc = scanner.nextLine();

        if (!newTitle.isBlank()) task.setTitle(newTitle);
        if (!newDesc.isBlank()) task.setDescription(newDesc);

        saveTasksToFile();
        System.out.println("Task updated and synced to file!");
    }

    // 4. Delete Task
    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found with ID: " + id);
            return;
        }

        taskList.remove(task);
        saveTasksToFile();
        System.out.println("Task deleted and file updated!");
    }

    // Helper: Save all tasks to file
    private static void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : taskList) {
                writer.write(t.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Helper: Load tasks from file on launch
    private static void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String desc = parts[2].trim();
                    taskList.add(new Task(id, title, desc));
                    if (id > maxId) {
                        maxId = id;
                    }
                }
            }
            nextId = maxId + 1;
            System.out.println("Loaded " + taskList.size() + " tasks from " + FILE_NAME);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading tasks file: " + e.getMessage());
        }
    }

    private static Task findTaskById(int id) {
        for (Task t : taskList) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}