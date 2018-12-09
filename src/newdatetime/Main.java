package newdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
		
		LocalDateTime dateTime= LocalDateTime.now();
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒")));
		
		Period period = Period.between(LocalDate.MIN, LocalDate.MAX);
		System.out.println(period.getYears()+"天");
		
		Instant instant = Instant.now();
		System.out.println(instant.getNano());
	}
}
