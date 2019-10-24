import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private int allowedValueForSecond =55;
	private long milliSeconds;
	private int seconds;
	
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
		
	}

	@Override
	public void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}