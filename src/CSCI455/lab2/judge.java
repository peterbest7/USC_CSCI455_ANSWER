package CSCI455.lab2;
import java.time.LocalDate;
import java.util.Scanner;

public class judge {
    public static void main(String[] args) {
        int m, d, y;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your birth month [1..12]: ");
        m = s.nextInt();
        System.out.print("Enter your birth day of month: ");
        d = s.nextInt();
        System.out.print("Enter your birth year [4-digit year] ");
        y = s.nextInt();
        while (!judgeDate(m, d, y)) {
            System.out.print("Enter your birth month [1..12]: ");
            m = s.nextInt();
            System.out.print("Enter your birth day of month: ");
            d = s.nextInt();
            System.out.print("Enter your birth year [4-digit year] ");
            y = s.nextInt();
        }
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int year = date.getYear();
        int mouth = date.getMonthValue();
        int age = year - y;
        int age1 = year - y - 1;
        LocalDate yourDate = LocalDate.of(y, m, d);
        try{
            LocalDate yourThisYearDate = LocalDate.of(year, m, d);
            if (localDateIsAfter(yourDate, date)) {
                System.out.println("You weren't born yet");
            } else {
                if (localDateIsEqual(yourThisYearDate, date)) {
                    System.out.println("Happy Birthday!");
                } else if (localDateIsAfter(yourThisYearDate, date)) {
                    System.out.println("Your birthday has not yet happened this year.");
                    System.out.println("You're " + age1 + " years old.");
                } else {
                    System.out.println("Your birthday has passed");
                    System.out.println("You're " + age + " years old.");
                }
            }
        }catch (Exception e){
            System.out.println("You don't have a birthday this year");
        }
        finally {

        }
        }



    public static boolean localDateIsEqual(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isEqual(secondDate);
    }
    public static boolean localDateIsAfter(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isAfter(secondDate);
    }
    public static boolean judgeDate(int m, int d, int y) {
        LocalDate now = LocalDate.now();
        int day = now.getDayOfMonth();
        int year = now.getYear();
        int mouth = now.getMonthValue();
        boolean flag = false;
        if (y > year || y < 1000) {
            flag = false;
            System.out.println("this year haven't happened yet or the year is before 1000");
        } else if (y == year && m > mouth) {
            flag = false;
            System.out.println("this month haven't happened yet");
        } else if (y == year && m == mouth && d > day) {
            flag = false;
            System.out.println("this day haven't happened yet");
        } else {
            if (m < 1 || m > 12) {
                System.out.println("the month is wrong, you should enter the month between 1 to 12");
                flag = false;
            } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                if (d <= 31) {
                    flag = true;
                } else {
                    flag = false;
                    System.out.println("please enter the day between 1 to 31 in 1,3,5,7,8,10,12 mouth");
                }
            } else if (m == 2) {
                if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                    if (d <= 29) {
                        flag = true;
                    } else {
                        flag = false;
                        System.out.println("in this year in 2 mouth the day is between 1 to 29, please enter the correct day");
                    }
                } else {
                    if (d <= 28) {
                        flag = true;
                    } else {
                        flag = false;
                        System.out.println("in this year in 2 mouth the day is between 1 to 28, please enter the correct day");
                    }
                }
            } else {
                if (d <= 30) {
                    flag = true;
                } else {
                    flag = false;
                    System.out.println("please enter the day between 1 to 30 in 4,6,9,11  mouth");
                }
            }
        }
        return flag;
    }
}

