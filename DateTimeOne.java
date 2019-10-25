import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private int allowedValueForSecond =55;
	private long milliSeconds;
	private int seconds;
	private HashMap<String, String> dates;
	
	public DateTimeOne() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("ss");
		Calendar cal = new GregorianCalendar();
		this.seconds = Integer.parseInt(dateFormat.format(cal.getTime()));
		
		
	}
	@Override
	public int getValueOfSecond() {
		
		return this.seconds;
	}

	@Override
	public void dateTimeNow() {

		SimpleDateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
		Calendar cal = new GregorianCalendar();
		System.out.println("Current Date/Time: " + dateFormate.format(cal.getTime()));
	
		
	}

	@Override
	public void sleepForFiveSec() {
		this.seconds += 5; 
	}

	@Override
	public void dateTimeOfOtherCity() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("k:mm");
		Calendar cal = new GregorianCalendar();
		
		int hours = cal.getTime().getHours();
		Date GMT = new Date();
		GMT.setHours(hours + 5);
		Date BST = new Date();
		BST.setHours(hours + 11);
		
		System.out.println("Time on Server: " + dateFormat.format(cal.getTime()));
		System.out.println("GMT: " + dateFormat.format(GMT));
		System.out.println("BST (90E): " + dateFormat.format(BST));
		System.out.println("CST (90W): " + dateFormat.format(cal.getTime()));
	}

	@Override
	public void dateTimeDifferentZone() {
		this.dates = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy k:mm");
		Calendar cal = new GregorianCalendar();
		
		int hours = cal.getTime().getHours();
		Date GMT = new Date();
		GMT.setHours(hours + 5);
		Date BST = new Date();
		BST.setHours(hours + 11);
		
		
		this.dates.put("GMT", dateFormat.format(GMT));
		this.dates.put("BST", dateFormat.format(BST));
		this.dates.put("CST", dateFormat.format(cal.getTime()));
		
		for(Entry<String, String> key : this.dates.entrySet()) {
			System.out.println(key.getKey() +": " + key.getValue());
		}
		
	}

	@Override
	public void timeZoneHashMap() {
		
HashMap<String, String> zones = new HashMap<>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy k:mm");
		Calendar cal = new GregorianCalendar();
		
		int hours = cal.getTime().getHours();
		Date GMT = new Date();
		GMT.setHours(hours + 5);
		Date BST = new Date();
		BST.setHours(hours + 1);
		Date AST = new Date("10/01/2020 19:59");
		Date ZST = new Date("11/05/2018 19:59");
		
		zones.put("AST", dateFormat.format(AST));
		zones.put("BST", dateFormat.format(BST));
		zones.put("CST", dateFormat.format(cal.getTime()));
		zones.put("GMT", dateFormat.format(GMT));
		zones.put("ZST", dateFormat.format(ZST));
		
		ArrayList<String> letterSortedkeys = new ArrayList<>();
		for (String key: zones.keySet()) {
			letterSortedkeys.add(key);
		}
		Collections.sort(letterSortedkeys);
		
		System.out.println("Print Style 1:");
		for(String key : letterSortedkeys) {
			System.out.println(key +" " + zones.get(key));
		}
		
		
	}
   
}