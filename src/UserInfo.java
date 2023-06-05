import java.io.*;
import java.util.Scanner;

public class UserInfo {
    public static String username;
    public static int age;
    public static String gender;
    public static int goal;
    public static int weight;
    public static int height;
    public static Scanner scanner;
    public static BufferedReader reader;
    public static PrintWriter writer;
    
    public static void storeUserInfo() throws IOException{
        try { 
            PrintWriter writer = new PrintWriter(new FileWriter("UserInfo.csv", true));
            writer.println(UserInfo.username.toLowerCase() + "/" + UserInfo.age + "/" + UserInfo.gender.toLowerCase() + "/" + UserInfo.weight + "/" + UserInfo.height);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            }
        }
        
    public static boolean isUsernameExists(String username) {
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

    public static void retrieveUserInfo(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserInfo.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("/");
                if (fields.length > 0 && fields[0].equalsIgnoreCase(username)) {
                    age = Integer.parseInt(fields[1]);
                    gender = fields[2];
                    //goal = Integer.parseInt(fields[3]);
                    weight = Integer.parseInt(fields[3]);
                    height = Integer.parseInt(fields[4]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void displayInformation() {
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("weight: " + weight);
        System.out.println("height: " + height);
        System.out.println("Goal: " + goal);

    }



    }