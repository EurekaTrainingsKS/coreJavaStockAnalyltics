import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatePlayGround {
    public static void main(String[] args) throws ParseException {
        Date date = new Date(); //not thread safe
        System.out.println("date value is :"+date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.parse("2023-12-10"));

        Instant instant = Instant.now();
        System.out.println("Instant time is :"+instant);
        System.out.println("5 mins back in time :"+instant.minusSeconds(300));
        System.out.println("Current System time is :"+instant.atZone(ZoneId.systemDefault()));

        LocalDate localDate = LocalDate.now(); //****which is thread safe
        System.out.println("Local date now is :"+localDate);
        System.out.println("5 months back in time: "+localDate.minusMonths(5));
        System.out.println("5 years back in time "+localDate.minusYears(5));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local dateTime now is :"+localDateTime);
        System.out.println("Plus 5 hrs to local time :"+localDateTime.plusHours(5));

        LocalDate localDateParse = LocalDate.parse("2026-20-11", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        System.out.println(localDateParse);
    }
}
