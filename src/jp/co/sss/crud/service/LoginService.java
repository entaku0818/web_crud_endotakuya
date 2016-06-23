package jp.co.sss.crud.service;

import jp.co.sss.crud.dao.EmployeeDAO;
import jp.co.sss.crud.entity.Employee;




public class LoginService {

	/**
	 * ログインをするメソッド
	 * @param id
	 * @param password
	 * @return boolean
	 */
	public boolean login(int id, String password)  {


		Employee loginData = new Employee();
		EmployeeDAO loginDao = new EmployeeDAO();

		//loginに使用するEmployeeテーブルデータを格納する
		loginData = loginDao.findById(id);

		//取得したデータのpasswordと引数で与えられたpasswordがマッチしているか確認する
		if( loginData.getEmpPass() != null && loginData.getEmpPass().equals(password) ){
			return true;
		}


		return false;
	}
	/**
	 * ログインしたときの権限を取得するメソッド
	 * @param id
	 * @return int authority
	 */
	public int getAuthority(int id) {
		Employee loginData = new Employee();
		EmployeeDAO loginDao = new EmployeeDAO();

		//loginに使用するEmployeeテーブルデータを格納する
		loginData = loginDao.findById(id);

		//取得したデータのpasswordと引数で与えられたpasswordがマッチしているか確認する
		return loginData.getAuthority();
	}




}
