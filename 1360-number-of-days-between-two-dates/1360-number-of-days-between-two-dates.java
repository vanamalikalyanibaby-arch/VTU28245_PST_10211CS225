class Solution {
    public int daysBetweenDates(String date1, String date2) {

        return Math.abs(toDays(date1) - toDays(date2));
    }

    private int toDays(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int total = 0;

        // Add days of previous years
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                total += 366;
            } else {
                total += 365;
            }
        }

        // Add days of previous months
        for (int m = 1; m < month; m++) {
            total += daysInMonth[m - 1];

            if (m == 2 && isLeapYear(year)) {
                total++;
            }
        }

        // Add current day
        total += day;

        return total;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}