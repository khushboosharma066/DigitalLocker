import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DigitalLocker {
    static Scanner sc = new Scanner(System.in);
    static final String USER_DATA_FILE = "users.txt";
    static final String LOCKER_FOLDER = "LockerFiles/";

    public static void main(String[] args) {
        new File(LOCKER_FOLDER).mkdir(); // Ensure locker folder exists

        System.out.println("Welcome to Digital Locker System");
        System.out.println("1. Register\n2. Login");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        String username = "", password = "";

        if (choice == 1) {
            System.out.print("Choose Username: ");
            username = sc.nextLine();
            System.out.print("Choose Password: ");
            password = sc.nextLine();
            registerUser(username, password);
        } else if (choice == 2) {
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            System.out.print("Enter Password: ");
            password = sc.nextLine();
            if (!loginUser(username, password)) return;
        }

        // User is logged in
        int option;
        do {
            System.out.println("\n1. Upload Document");
            System.out.println("2. View My Documents");
            System.out.println("3. Exit");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> uploadFile(username);
                case 2 -> listUserFiles(username);
            }
        } while (option != 3);
    }

    static void registerUser(String username, String password) {
        try (FileWriter fw = new FileWriter(USER_DATA_FILE, true)) {
            fw.write(username + "," + password + "\n");
            System.out.println("Registered successfully.");
        } catch (IOException e) {
            System.out.println("Error registering user.");
        }
    }

    static boolean loginUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Login successful.");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data.");
        }
        System.out.println("Invalid credentials.");
        return false;
    }

    static void uploadFile(String username) {
        System.out.println("Enter full path of file to upload: ");
        System.out.println("(For files with spaces in name, just copy-paste the full path)");
        System.out.println("Example: C:\\Users\\khushboo\\OneDrive\\Desktop\\pre-assessment (lecture-3) Copy.pdf");
        
        String sourcePath = sc.nextLine();
        // Clean up the path by removing any quotes, ampersands, or extra spaces
        sourcePath = sourcePath.replace("\"", "").replace("&", "").replace("'", "").trim();
        
        // Handle paths with spaces
        if (!sourcePath.startsWith("\"") && sourcePath.contains(" ")) {
            sourcePath = "\"" + sourcePath + "\"";
        }
        
        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.out.println("File not found at: " + sourcePath);
            System.out.println("Please check that:");
            System.out.println("1. The file path is correct");
            System.out.println("2. Make sure you copied the complete path");
            System.out.println("3. Try removing any special characters like & or ' from the beginning");
            return;
        }

        File userFolder = new File(LOCKER_FOLDER + username);
        userFolder.mkdirs();

        File destFile = new File(userFolder, sourceFile.getName());

        try {
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File '" + sourceFile.getName() + "' uploaded successfully.");
        } catch (IOException e) {
            System.out.println("File upload failed. Error: " + e.getMessage());
            e.printStackTrace(); // This will help us see more detailed error information
        }
    }

    static void listUserFiles(String username) {
        File userFolder = new File(LOCKER_FOLDER + username);
        if (!userFolder.exists() || Objects.requireNonNull(userFolder.list()).length == 0) {
            System.out.println("No files uploaded.");
            return;
        }

        System.out.println("Your Uploaded Files:");
        for (String file : Objects.requireNonNull(userFolder.list())) {
            System.out.println("- " + file);
        }
    }
}
