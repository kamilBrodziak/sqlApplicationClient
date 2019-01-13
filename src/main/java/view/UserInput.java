package view;

import model.Applicant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    public static String getSearchPhrase() {
        String searchPhrase = "";
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            searchPhrase = scanner.nextLine();
        }

        return searchPhrase.toLowerCase();
    }

    public static Applicant getNewApplicant() {
        Scanner scanner = new Scanner(System.in);
        String firstName = "", lastName = "", phoneNumber = "", email = "";
        int applicationCode = 0;

        System.out.println("Enter first name:");
        if(scanner.hasNextLine()) {
            firstName = scanner.nextLine();
        }

        System.out.println("Enter last name:");
        if(scanner.hasNextLine()) {
            lastName = scanner.nextLine();
        }

        System.out.println("Enter phone number:");
        if(scanner.hasNextLine()) {
            phoneNumber = scanner.nextLine();
        }

        System.out.println("Enter email:");
        if(scanner.hasNextLine()) {
            email = scanner.nextLine();
        }

        System.out.println("Enter application code");
        if(scanner.hasNextInt()) {
            applicationCode = scanner.nextInt();
        }

        return new Applicant(firstName, lastName, phoneNumber, email, applicationCode);
    }

    public static List<String> getApplicantNameAndPhone() {
        Scanner scanner = new Scanner(System.in);
        List<String> nameAndPhone = new ArrayList<>();
        String firstName = "", lastName = "", phoneNumber = "";

        System.out.println("Enter first name:");
        if(scanner.hasNextLine()) {
            firstName = scanner.nextLine();
            nameAndPhone.add(firstName);
        }

        System.out.println("Enter last name:");
        if(scanner.hasNextLine()) {
            lastName = scanner.nextLine();
            nameAndPhone.add(lastName);
        }

        System.out.println("Enter new phone number:");
        if(scanner.hasNextLine()) {
            phoneNumber = scanner.nextLine();
            nameAndPhone.add(phoneNumber);
        }

        return nameAndPhone;
    }

    public static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        String email = "";

        System.out.println("Enter email or part of it:");
        if(scanner.hasNextLine()) {
            email = scanner.nextLine();
        }

        return email;
    }
}
