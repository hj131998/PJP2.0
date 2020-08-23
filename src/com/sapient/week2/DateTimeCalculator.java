package com.sapient.week2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeCalculator {

	private int year;
	private int month;
	private int day;
	private int totalDay;

	@Override
	public String toString() {
		return "DateTimeCalculator [year=" + year + ", month=" + month + ", day=" + day + ", totalDay=" + totalDay
				+ "]";
	}

	public DateTimeCalculator() {

	}

	public DateTimeCalculator(int year, int month, int day, int totalDay) {
		this.year = 0;
		this.year = year;
		this.month = month;
		this.day = day;
		this.totalDay = totalDay;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getTotalDay() {
		return totalDay;
	}

	public static int MonthsToDays(int tMonth, int tYear) {
		if (tMonth == 1 || tMonth == 3 || tMonth == 5 || tMonth == 7 || tMonth == 8 || tMonth == 10 || tMonth == 12) {
			return 31;
		} else if (tMonth == 2) {
			if (tYear % 4 == 0) {
				if (tYear % 100 == 0) {
					if (tYear % 400 == 0)
						return 29;
					else
						return 28;
				} else
					return 29;
			} else {
				return 28;
			}
		} else {
			return 30;
		}
	}

//	Calculate Age in years, months and days and total days

/*	public static void daysBetween(int mDay, int mMonth, int mYear, int tDay, int tMonth, int tYear)
	{
		
		
			
		
		LocalDate date1 = LocalDate.of(mYear, mMonth, mDay);
		LocalDate date2 = LocalDate.of(tYear, tMonth, tDay);
		
		Period diff = Period.between(date1, date2);
		 
		System.out.printf("Difference is %d years, %d months and %d days old", 
		                    diff.getYears(), diff.getMonths(), diff.getDays());
		
	}
	*/
	
	public static DateTimeCalculator calculateAge(int mDay, int mMonth, int mYear, int tDay, int tMonth, int tYear) {
		String mDateInString = mDay + " " + mMonth + " " + mYear;
		String tDateInString = tDay + " " + tMonth + " " + tYear;
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
		try {
			Date mDate = formatter.parse(mDateInString);
			Date tDate = formatter.parse(tDateInString);
			long d1 = mDate.getTime();
			long d2 = tDate.getTime();
			if (d1 > d2) {
				int tempDay = mDay;
				int tempMonth = mMonth;
				int tempYear = mYear;
				mDay = tDay;
				mMonth = tMonth;
				mYear = tYear;

				tDay = tempDay;
				tMonth = tempMonth;
				tYear = tempYear;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int totalDays = gregorianDays(tYear, tMonth, tDay) - gregorianDays(mYear, mMonth, mDay);
		int mYearDiff = tYear - mYear;
		int mMonDiff = tMonth - mMonth;

		if (mMonDiff < 0) {
			mYearDiff = mYearDiff - 1;
			mMonDiff = mMonDiff + 12;
		}

		int mDayDiff = tDay - mDay;
		if (mDayDiff < 0) {
			if (mMonDiff > 0) {
				mMonDiff = mMonDiff - 1;
				mDayDiff = mDayDiff + MonthsToDays(tMonth - 1, tYear);
			} else {
				mYearDiff = mYearDiff - 1;
				mMonDiff = 11;
				mDayDiff = mDayDiff + MonthsToDays(tMonth - 1, tYear);
				;
			}

		}

		return new DateTimeCalculator(mYearDiff, mMonDiff, mDayDiff, totalDays);
	}

	private static int gregorianDays(int year, int month, int day) {
		month = (month + 9) % 12;
		year = year - month / 10;
		return 365 * year + year / 4 - year / 100 + year / 400 + (month * 306 + 5) / 10 + (day - 1);

	}

	public static String getDayStringOld(Date date, Locale locale) {
		DateFormat formatter = new SimpleDateFormat("EEEE", locale);
		return formatter.format(date);
	}

	public static int getDayNumberOld(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static int getWeekNumber(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

}
