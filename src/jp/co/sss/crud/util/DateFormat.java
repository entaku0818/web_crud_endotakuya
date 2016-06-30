package jp.co.sss.crud.util;

import java.util.Date;
import java.text.SimpleDateFormat;


public class DateFormat {


	/**
	 * 受け取ったJavaのDate型をSQLのDate型へ変更する
	 * @param date
	 * @return
	 */
	public String chgDateToSql(Date date) {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	String daySql = sdf.format(date);

	return daySql;


	}
}
