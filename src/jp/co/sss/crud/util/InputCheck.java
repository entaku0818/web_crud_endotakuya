package jp.co.sss.crud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.dto.SysDataDto;
import jp.co.sss.crud.form.ChangeForm;



public class InputCheck {



	/**
	 *
	 * @param changeForm
	 * @return
	 */
	public boolean check(ChangeForm changeForm) {

		boolean flag = true;
		SysDataDto SysDataDto = new SysDataDto();


		if( !this.stringCheck(changeForm.getEmpPass(), 1,30) ){
			flag = false;
			SysDataDto.setErrorMessage( SysDataDto.getErrorMessage() + "パスワードは1文字以上15文字以下で入力してください");

		}
		if( !this.stringCheck(changeForm.getEmpName(), 1,15) ){
			flag = false;
			SysDataDto.setErrorMessage( SysDataDto.getErrorMessage() + "社員名は1文字以上15文字以下で入力してください");

		}
		if( !this.stringCheck(changeForm.getAddress(), 1,30) ){
			flag = false;
			SysDataDto.setErrorMessage( SysDataDto.getErrorMessage() + "社員名は1文字以上15文字以下で入力してください");

		}
		if( !this.dateCheck(changeForm.getBirthday()) ){
			flag = false;
			SysDataDto.setErrorMessage( SysDataDto.getErrorMessage() + "日付は「yyyy/MM/dd」形式で入力してください");

		}








		return flag;

	}


	private boolean dateCheck(String birthday) {

		//ここで日付Check
		boolean flag = false;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			sdf.setLenient(false);
			sdf.parse(birthday);
			flag = true;

		} catch (ParseException e) {
			flag = false;
		}

		return flag;
	}


	/**
	 *
	 * @param intInput
	 * @param intMin
	 * @param intMax
	 * @return
	 */
	  public boolean intCheck(int Input,int Min, int Max) {


	        if (Input < Min || Input > Max) {
	        		return false;
	        }
	        return true;
	    }
	  /**
	   *
	   * @param intInput
	   * @param intMin
	   * @param intMax
	   * @return
	   */
	  public boolean stringCheck(String string,int Min, int Max) {

	        if (string.length() < Min || string.length() > Max) {
        		return false;
	        }
	        return true;
	    }
}
