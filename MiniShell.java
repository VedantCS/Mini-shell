import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MiniShell {

    static File currentDir = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to JavaShell!");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                System.out.println("Goodbye!");
                break;

            } else if (input.equals("pwd")) {
                printWorkingDirectory();

            } else if (input.equals("ls")) {
                listFiles();

            } else if (input.startsWith("cd ")) {
                changeDirectory(input.substring(3).trim());

            } else if (input.startsWith("touch ")) {
                createFile(input.substring(6).trim());

            } else if (input.startsWith("rm ")) {
                deleteFile(input.substring(3).trim());

            } else if (input.equals("help")) {
                showHelp();

            } else {
                System.out.println("Unknown command: " + input);
            }
        }

        scanner.close();
    }

    // Show the current working directory
    public static void printWorkingDirectory() {
        try {
            System.out.println(currentDir.getCanonicalPath());
        } catch (IOException e) {
            System.out.println("Error getting current directory.");
        }
    }

    // List files in the current directory
    public static void listFiles() {
        File[] files = currentDir.listFiles();
        if (files == null) {
            System.out.println("Unable to list files.");
            return;
        }
        for (File file : files) {
            System.out.println(file.getName() + (file.isDirectory() ? "/" : ""));
        }
    }

    // Change to a different directory
    public static void changeDirectory(String dirName) {
        File newDir = new File(currentDir, dirName);
        if (newDir.exists() && newDir.isDirectory()) {
            currentDir = newDir;
        } else {
            System.out.println("Directory not found: " + dirName);
        }
    }

    // Create a new empty file
    public static void createFile(String fileName) {
        File newFile = new File(currentDir, fileName);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Failed to create file: " + fileName);
        }
    }

    // Delete a file
    public static void deleteFile(String fileName) {
        File file = new File(currentDir, fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("Deleted: " + fileName);
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File not found or is a directory: " + fileName);
        }
    }

    // Show help with available commands
    public static void showHelp() {
        System.out.println("Available commands:");
        System.out.println("pwd        - Print current working directory");
        System.out.println("ls         - List files and directories in current directory");
        System.out.println("cd <dir>   - Change to a different directory");
        System.out.println("touch <file> - Create a new empty file");
        System.out.println("rm <file>  - Delete a file");
        System.out.println("exit       - Exit the shell");
        System.out.println("help       - Show this help message");
    }
}
