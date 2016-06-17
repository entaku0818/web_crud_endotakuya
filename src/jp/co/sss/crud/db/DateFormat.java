package jp.co.sss.crud.db;

import java.util.Calendar;


public class DateFormat {


	public java.sql.Date chgDateToSql(java.util.Date dayJava) {

	Calendar cal = Calendar.getInstance();
	cal.setTime(dayJava);
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	java.sql.Date daySql = new java.sql.Date(cal.getTimeInMillis());
	return daySql;
	}
}
