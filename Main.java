package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your first name:  ");
        String firstName = scanner.nextLine();


        System.out.println("Enter your last name:  ");
        String lastName = scanner.nextLine();

        System.out.println("Enter a username ,but ensure that your username contains an _ and is no more than 5 characters in length : ");
        String username = scanner.nextLine();
        System.out.println("Enter a password ,please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character:  ");
        String password = scanner.nextLine();

        System.out.println("Enter your phone number ,it should start with +27 : ");
        String phoneNumber = scanner.nextLine();

        Login loginUser = new Login(firstName, lastName, password,phoneNumber,username);

        String regMessage = loginUser.registerUser(username, password, phoneNumber);
        System.out.println(regMessage);

        if (regMessage.equals("User is registered successfully.")) {
            System.out.println("Enter your username to login: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password to login: ");
            String loginPass = scanner.nextLine();

            String loginMessage = loginUser.loginStatus(loginUsername, loginPass);
            System.out.println(loginMessage);
        }

        scanner.close();


    }
}