package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Room number: ");
        int number =sc.nextInt();
        System.out.print("Chech-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout =sdf.parse(sc.next());

        if (! checkout.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date ");
        }else {
            Reservation rs = new Reservation(number,checkin,checkout);
            System.out.println(" Reservation: " + rs);

            System.out.println("Enter data to uptdate the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin=sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout=sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("Error in reservation: Check-out date must be after check-in date ");
            }else {
                if (!checkout.after(checkin)){
                    System.out.println("Error in reservation: Check-out date must be after check-in date ");

                }else {
                    rs.updateDates(checkin,checkout);
                    System.out.println("Reservetion: "+ rs );
                }
            }

            rs.updateDates(checkin,checkout);
            System.out.print("Reservation: " + rs);

        }



        sc.close();

    }
}