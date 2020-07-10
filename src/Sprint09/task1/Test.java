package Sprint09.task1;

import java.time.LocalDate;
import java.time.Month;
import java.util.GregorianCalendar;

public class Test {
    public static boolean isLeapYear(int year) {
        LocalDate d = LocalDate.of(year, 1, 18);

        if (d.isLeapYear()) {

            return true;
        }else
            return false;

    }
}
