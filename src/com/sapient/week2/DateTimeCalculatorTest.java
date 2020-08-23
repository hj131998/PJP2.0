package com.sapient.week2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeCalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice;
		String date1, date2;
		Date mDate1 = null, mDate2 = null;
        do
        {	
		System.out.println("1. To Determine day of the Week for the given date");
		System.out.println("2. To Determine week No for a given date");
		System.out.println("3. Subtract 2 dates and get result in format as your wish");

		System.out.println("Please Enter a choice");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();

		System.out.println("Your Choice is : " + choice);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");

		switch (choice) {

		case 1:
			System.out.println("Enter date in the format dd mm yyyy");
			sc = new Scanner(System.in);
			date1 = sc.nextLine();

			System.out.println("Date Entered is : " + date1);

			try {
				mDate1 = formatter.parse(date1);
//				System.out.println(DateTimeCalculator.getDayNumberOld(mDate1));
				System.out.println(DateTimeCalculator.getDayStringOld(mDate1, Locale.ENGLISH));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 2:
			System.out.println("Enter date in the format dd mm yyyy");
			sc = new Scanner(System.in);
			date1 = sc.nextLine();

			System.out.println("Date Entered is : " + date1);

			try {
				mDate1 = formatter.parse(date1);
				System.out.println(DateTimeCalculator.getWeekNumber(mDate1));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 3:
			System.out.println("Enter 1st Date in the format dd mm yyyy");
			sc = new Scanner(System.in);
			date1 = sc.nextLine();

			System.out.println("Enter 2nd Date in the format dd mm yyyy");
			sc = new Scanner(System.in);
			date2 = sc.nextLine();

			try {
				mDate1 = formatter.parse(date1);
				mDate2 = formatter.parse(date2);

				Calendar cal = Calendar.getInstance();
				cal.setTime(mDate1);
				int d1 = cal.get(Calendar.DAY_OF_MONTH);
				// since month is starting from 0, i need to add 1
				int m1 = cal.get(Calendar.MONTH);
				int y1 = cal.get(Calendar.YEAR);

				cal.setTime(mDate2);
				int d2 = cal.get(Calendar.DAY_OF_MONTH);
				// since month is starting from 0, i need to add 1
				int m2 = cal.get(Calendar.MONTH);
				int y2 = cal.get(Calendar.YEAR);

				System.out.println(DateTimeCalculator.calculateAge(d1, m1 + 1, y1, d2, m2 + 1, y2));
				//DateTimeCalculator.daysBetween(d1, m1 + 1, y1, d2, m2 + 1, y2);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Please make a choice");

		}}while(true);


	}

}
