package jp.co.sss.crud.util;


public class InputCheck {


	/**
	 *
	 * @param intInput
	 * @param intMin
	 * @param intMax
	 * @return
	 */
	  public boolean intcheck(int intInput,int intMin, int intMax) {


	        if (intInput < intMin || intInput > intMax) {

	            System.err.println(intMin + "以上" + intMax + "以下の整数を入力してください。");

	        }
	        return true;
	    }
}
