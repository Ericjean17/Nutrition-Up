import java.io.*;
import java.util.Scanner;

public class UserInfo {
    public static String username;
    private static int age;
    private static String gender;
    private static int goal;
    private static int weight;
    private static int height;
    private static Scanner scanner;

    public UserInfo() {
        scanner = new Scanner(System.in);
    }

    public static void askUsername() {
        System.out.print("Please enter your username: ");
        username = scanner.nextLine();
    }
    
    public static void storeUsername() throws IOException{
        try { 
            PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv", true));
            writer.println(UserInfo.username.toLowerCase());
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            }
        }
        
    private static boolean isUsernameExists(String username) {
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

    private static void retrieveUserInfo(String username) {
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

    public static void askAge() {
        System.out.print("Please enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    }

    public static void askGender() {
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
    public static void askWeight() {
        System.out.print("Please enter your Weight in kg: ");
        weight = scanner.nextInt();
        scanner.nextLine();
    }
    public static void askHeight() {
        System.out.print("Please enter your Height in cm: ");
        height = scanner.nextInt();
        scanner.nextLine();
    }
    public static void askGoal() {
        System.out.print("Please enter your goal: ");
        goal = scanner.nextInt();
        scanner.nextLine();
    }

    public static void displayInformation() {
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
            UserInfo.askUsername();
            if (UserInfo.isUsernameExists(UserInfo.username)) {
                UserInfo.retrieveUserInfo(UserInfo.username);
                UserInfo.displayInformation();
            } else {
                System.out.println("Username does not exist. Please sign up.");
            }
        } else if (choice.equals("signup")) {
            boolean uniqueUsername = false;
            while (!uniqueUsername) {
                UserInfo.askUsername();
                if (!UserInfo.isUsernameExists(UserInfo.username)) {
                    uniqueUsername = true;
                    UserInfo.askAge();
                    UserInfo.askGender();
                    UserInfo.askWeight();
                    UserInfo.askHeight();
                    UserInfo.askGoal();

                    UserInfo.displayInformation();
                    try (PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv", true))) {
                        writer.println(UserInfo.username.toLowerCase() + "/" + UserInfo.age + "/" + UserInfo.gender.toLowerCase() + "/" + UserInfo.weight + "/" + UserInfo.height + "/" + UserInfo.goal);
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