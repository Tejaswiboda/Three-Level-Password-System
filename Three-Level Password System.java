import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String graphicalPassword;
    private String securityAnswer;

    public User(String username, String password, String graphicalPassword, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.graphicalPassword = graphicalPassword;
        this.securityAnswer = securityAnswer;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public boolean validateGraphicalPassword(String graphicalPassword) {
        return this.graphicalPassword.equals(graphicalPassword);
    }

    public boolean validateSecurityAnswer(String securityAnswer) {
        return this.securityAnswer.equals(securityAnswer);
    }
}

class ThreeLevelPasswordSystem {
    private User user;

    public ThreeLevelPasswordSystem(User user) {
        this.user = user;
    }

    public boolean authenticate(String password, String graphicalPassword, String securityAnswer) {
        return user.validatePassword(password) &&
               user.validateGraphicalPassword(graphicalPassword) &&
               user.validateSecurityAnswer(securityAnswer);
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the user with all three levels of authentication
        User user = new User("john_doe", "mySecret123", "image2", "blue");

        ThreeLevelPasswordSystem system = new ThreeLevelPasswordSystem(user);
        Scanner scanner = new Scanner(System.in);

        // Level 1: Textual Password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Level 2: Graphical Password
        System.out.print("Select your graphical password (e.g., image1, image2, image3): ");
        String graphicalPassword = scanner.nextLine();

        // Level 3: Security Question
        System.out.print("Answer your security question (e.g., favorite color): ");
        String securityAnswer = scanner.nextLine();

        // Authenticate the user
        if (system.authenticate(password, graphicalPassword, securityAnswer)) {
            System.out.println("Authentication successful! Access granted.");
        } else {
            System.out.println("Authentication failed! Access denied.");
        }

        scanner.close();
    }
}