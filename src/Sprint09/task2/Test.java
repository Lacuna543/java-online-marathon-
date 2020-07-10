package Sprint09.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static String getDateAfterToday(int years, int months, int days) {

        LocalDate localDate = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);

        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
