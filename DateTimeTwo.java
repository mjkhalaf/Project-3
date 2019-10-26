import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;

public class DateTimeTwo {
	Calendar cal;
	private ArrayList<String> datesfile;
	private HashMap<LocalDate, Integer> datesMap;
	
	public DateTimeTwo() {
		
	}
	public void daysOfCurrentMonth() {
		
		Date now = new Date();	
		now.setDate(10);
		LocalDateTime tenth = LocalDateTime.of(now.getYear() + 1900, now.getMonth() + 1
				,now.getDate(),now.getHours(), now.getMinutes());
		
		Date now2 = new Date();	
		now2.setDate(18);
		LocalDateTime eighteenth = LocalDateTime.of(now2.getYear() + 1900, now2.getMonth() + 1
				,now2.getDate(),now2.getHours(), now2.getMinutes());
		
		System.out.println("The tenth day of this month is " + tenth.getDayOfWeek() 
		+" and eighteenth is " + eighteenth.getDayOfWeek());
	}
	public void daysOfAnyMonth(int month, int year) {
		Date now = new Date();
		now.setMonth(month - 1);
		now.setYear(year - 1900);
		now.setDate(15);
		LocalDateTime fifteenth = LocalDateTime.of(now.getYear() + 1900, now.getMonth() + 1
				,now.getDate(),now.getHours(), now.getMinutes());
		
		Calendar cal = new GregorianCalendar();
		Date now2 = new Date();
		now2.setMonth(month - 1);
		now2.setYear(year - 1900);
		cal.setTime(now2);
		
		LocalDateTime last = LocalDateTime.of(now2.getYear() + 1900, now2.getMonth() + 1
				,cal.getActualMaximum(cal.DAY_OF_MONTH),now2.getHours(), now2.getMinutes());
		System.out.println("For the year ("+ year + ") and month (" + month +"), the fifteenth day is " +  
				fifteenth.getDayOfWeek() + " and the last day is " + last.getDayOfWeek());
		
	}
	public void compareYear() throws IOException {
		
		//File file = new File("C:\\Users\\m7md2\\Desktop\\Mohammed_Project3\\Project 3\\src\\Dates.txt");
		BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
		datesfile = new ArrayList<>();
		String currLine = br.readLine();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		
		while (currLine != null) {
			datesfile.add(currLine.substring(0, 10));
		}
		
		br.close();
		
		int i = 1;
		for(String k: datesfile) {
		datesMap.put(LocalDate.parse(k, format), i);
		i++;
		}
		
		LocalDate current = LocalDate.now();
		 
		for(Entry<LocalDate, Integer> key : datesMap.entrySet()) {
			
			int yearDays = key.getKey().lengthOfYear();
			
			Period diff = Period.between(key.getKey(), current);
			LocalDate now = key.getKey();
			
			if (yearDays == 365 ) {
				System.out.println(now.getYear() + " is not a leap year, and Difference: " 
						+ diff.getYears() + " years, " +
						diff.getMonths() +" months, and " + diff.getDays() + " days.");
			}
			else {
				System.out.println(now.getYear() + " is a leap year, and Difference: " 
						+ diff.getYears() + " years, " +
						diff.getMonths() +" months, and " + diff.getDays() + " days.");
			}
			
		}

		
	}
	public void dateHashMap() {

		for(Entry<LocalDate, Integer> key : datesMap.entrySet()) {
			System.out.println(key.getKey() + ":" + key.getValue());
		}
		
	}
	public void dateHashMapSorted() {
		
		ArrayList<LocalDate> sortedDates = new ArrayList<>();
		for (Entry<LocalDate, Integer> o : datesMap.entrySet()) {
			sortedDates.add(o.getKey());
		}
		Collections.sort(sortedDates);
		for(LocalDate o : sortedDates) {
			
			System.out.println(o + ":" + datesMap.get(o));
		}
		
	
		
	}

}
