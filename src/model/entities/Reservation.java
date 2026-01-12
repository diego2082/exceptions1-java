package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkout) {

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {// Verifica se a data de check-in OU a data de check-out está no passado
            return "Reservation dates for update must be future dates";
        }
        if (!checkOut.after(checkIn)) {
            return "Checkout date must be after check-in date" ;
        }
        this.checkIn = checkIn;
        this.checkOut = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
