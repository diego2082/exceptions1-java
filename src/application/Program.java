package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date: (dd/MM/yyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-ou date: (dd/MM/yyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {// Verifica se a data de check-out NÃO é depois da de check-in
            System.out.println("Error in reservation: Checkout date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);   // Cria o objeto Reservation com o número e as datas
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update reservation:");
            System.out.print("Check-in date: (dd/MM/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }

    }
}