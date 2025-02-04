/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     *
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }


    /**
     * Returns the name of the day given by dayValue
     *
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue) {
        dayValue = dayValue % 7; //removes extra days to have days 0 - 6
        if (dayValue < 0) {
            dayValue = dayValue + 7; // accounts for negative numbers
        }
        if (dayValue == 0) {
            return "Sunday";
        } else if (dayValue == 1) {
            return "Monday";
        } else if (dayValue == 2) {
            return "Tuesday";
        } else if (dayValue == 3) {
            return "Wednesday";
        } else if (dayValue == 4) {
            return "Thursday";
        } else if (dayValue == 5) {
            return "Friday";
        } else {
            return "Saturday";
        }
    }

    /**
     * \
     * Returns the numeric value of the month.
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name) {
        if (name.equalsIgnoreCase("January")) {
            return 1;
        } else if (name.equalsIgnoreCase("February")) {
            return 2;
        } else if (name.equalsIgnoreCase("March")) {
            return 3;
        } else if (name.equalsIgnoreCase("April")) {
            return 4;
        } else if (name.equalsIgnoreCase("May")) {
            return 5;
        } else if (name.equalsIgnoreCase("June")) {
            return 6;
        } else if (name.equalsIgnoreCase("July")) {
            return 7;
        } else if (name.equalsIgnoreCase("August")) {
            return 8;
        } else if (name.equalsIgnoreCase("September")) {
            return 9;
        } else if (name.equalsIgnoreCase("October")) {
            return 10;
        } else if (name.equalsIgnoreCase("November")) {
            return 11;
        } else if (name.equalsIgnoreCase("December")) {
            return 12;
        } else {
            return -1;
        }
    }

    /**
     * Returns the name of the month given the numeric value provided by month
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the numeric value of the month
     * @param year  year
     * @return the number of days in the month given by the parameter month
     */
    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 13) {
            return -1;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return -1;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the name of the month
     * @param year  year
     * @return the number of days in the month
     */
    public static int getDaysInMonth(String month, int year) {
        int monthNum = getMonthNumber(month);
        if (monthNum == -1) {
            return -1;
        }
        return getDaysInMonth(monthNum, year);
    }

    /**
     * Returns the offset in days for the month relative to January
     *
     * @param month numeric value of the month
     * @param year  year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year) {
        if (month < 1 || month > 13) {
            return -1;
        }
        if (month == 1) {
            return 0;
        } else if (month == 2) {
            return 3;
        } else if (month == 3) {
            if (isLeapYear(year)) {
                return 4;
            } else {
                return 3;
            }
        } else if (month == 4) {
            return 6;
        } else if (month == 5) {
            return 1;
        } else if (month == 6) {
            return 4;
        } else if (month == 7) {
            return 6;
        } else if (month == 8) {
            return 2;
        } else if (month == 9) {
            return 5;
        } else if (month == 10) {
            return 0;
        } else if (month == 11) {
            return 3;
        } else if (month == 12) {
            return 5;
        } else {
            return -1;
        }
    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      numeric value of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year) {
        int diff = getMonthOffset(month, year);
        if (diff == -1) {
            return -1;
        }
        int daysInTheYear = diff + dayOfMonth - 1;
        return (daysInTheYear % 7);

    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      name of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month, int dayOfMonth, int year) {
        int monthNum = getMonthNumber(month);
        if (monthNum == -1) {
            return -1;
        }
        return dayOfWeek(monthNum, dayOfMonth, year);
    }
}