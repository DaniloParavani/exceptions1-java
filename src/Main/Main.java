package Main;

import Model.Entities.Reservation;
import Model.Exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation : " + reservation);
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        }
//        catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Illegal format");
        }

        sc.close();
    }
}
