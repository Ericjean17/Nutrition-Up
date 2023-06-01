import java.io.*;
import java.util.Scanner;

public class UserInfo {
    private String username;
    private int age;
    private String gender;
    private int goal;
    private int weight;
    private int height;
    private Scanner scanner;

    public UserInfo() {
        scanner = new Scanner(System.in);
    }

    public void askUsername() {
        System.out.print("Please enter your username: ");
        username = scanner.nextLine();
    }

    private boolean isUsernameExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 0 && fields[0].equalsIgnoreCase(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void retrieveUserInfo(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 0 && fields[0].equalsIgnoreCase(username)) {
                    age = Integer.parseInt(fields[1]);
                    gender = fields[2];
                    goal = Integer.parseInt(fields[3]);
                    weight = Integer.parseInt(fields[4]);
                    height = Integer.parseInt(fields[5]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void askAge() {
        System.out.print("Please enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    }

    public void askGender() {
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Please enter your gender (male/female): ");
            gender = scanner.nextLine().toLowerCase();

            if (gender.equals("male") || gender.equals("female")) {
                validGender = true;
            } else {
                System.out.println("Please enter either 'male' or 'female'.");
            }
        }
    }
    public void askWeight() {
        System.out.print("Please enter your Weight: ");
        weight = scanner.nextInt();
        scanner.nextLine();
    }
    public void askHeight() {
        System.out.print("Please enter your Height: ");
        height = scanner.nextInt();
        scanner.nextLine();
    }
    public void askGoal() {
        System.out.print("Please enter your goal: ");
        goal = scanner.nextInt();
        scanner.nextLine();
    }



    public void displayInformation() {
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("weight: " + weight);
        System.out.println("height: " + height);
        System.out.println("Goal: " + goal);

    }

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome! Do you want to login or sign up? (login/signup): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("login")) {
            userInfo.askUsername();
            if (userInfo.isUsernameExists(userInfo.username)) {
                userInfo.retrieveUserInfo(userInfo.username);
                userInfo.displayInformation();
            } else {
                System.out.println("Username does not exist. Please sign up.");
            }
        } else if (choice.equals("signup")) {
            boolean uniqueUsername = false;
            while (!uniqueUsername) {
                userInfo.askUsername();
                if (!userInfo.isUsernameExists(userInfo.username)) {
                    uniqueUsername = true;
                    userInfo.askAge();
                    userInfo.askGender();
                    userInfo.askWeight();
                    userInfo.askHeight();
                    userInfo.askGoal();

                    userInfo.displayInformation();
                    try (PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv", true))) {
                        writer.println(userInfo.username.toLowerCase() + "/" + userInfo.age + "/" + userInfo.gender.toLowerCase() + "/" + userInfo.goal + "/" + userInfo.weight + "/" + userInfo.height);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Username already exists. Please choose a different username.");
                }
            }
        } else {
            System.out.println("Invalid choice. Please choose either 'login' or 'signup'.");
        }

        scanner.close();
    }
}