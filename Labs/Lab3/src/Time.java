/**
 * This class simulates a time by holding a number of hours, minutes, and seconds
 *
 * @author Alexander Melis
 * @version 1.0
 * @since 3/11/2026
 */

public class Time {

    private int hours, minutes, seconds;

    // Creates a time using the system's elapsed time
    public Time() {
        int[] time = parseTime(System.currentTimeMillis());

        seconds = time[0];
        minutes = time[1];
        hours = time[2];
    }

    // Creates a time with the given elapsed time
    public Time(long milliseconds) {
        int[] time = parseTime(milliseconds);

        seconds = time[0];
        minutes = time[1];
        hours = time[2];
    }

    // Creates a time with given hours, minutes, and seconds
    public Time(int hours, int  minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Gets seconds
    public int getSeconds() {
        return seconds;
    }

    // Gets minutes
    public int getMinutes() {
        return minutes;
    }

    // Gets hours
    public int getHours() {
        return hours;
    }

    // Sets time with given milliseconds
    public void setTime(long milliseconds) {
        int[] time = parseTime(milliseconds);

        seconds = time[0];
        minutes = time[1];
        hours = time[2];
    }

    // Override for printing
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    // Helper method
    private int[] parseTime(long millisecondsTime) {
        int realSeconds = (int) (millisecondsTime / 1000 % 60);
        int realMinutes = (int) (millisecondsTime / 60000 % 60);
        // Converted for PST
        int realHours = (int) (millisecondsTime / 3600000 % 24 - 7);

        return new int[]{ realSeconds, realMinutes, realHours };
    }

    public static void main(String args[]) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        Time time3 = new Time(5, 23, 55);

        System.out.println("Time 1: " + time1 + "\nTime 2: " + time2 + "\nTime 3: " + time3);
    }
}
