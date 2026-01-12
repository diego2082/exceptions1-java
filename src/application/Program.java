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

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {// Verifica se a data de check-in OU a data de check-out está no passado
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Checkout date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

    }
}