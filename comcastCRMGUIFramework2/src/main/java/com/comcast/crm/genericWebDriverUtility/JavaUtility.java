package com.comcast.crm.genericWebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random ranDom=new Random();
		int randomNumber=ranDom.nextInt(5000);
		return randomNumber;
		
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateobj);
		return date;
		
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
			
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String dateRequired=sim.format(cal.getTime());
		return dateRequired;
		
        
		
	}

}
