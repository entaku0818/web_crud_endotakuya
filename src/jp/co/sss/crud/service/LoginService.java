package jp.co.sss.crud.service;

import jp.co.sss.crud.dao.EmployeeDAO;
import jp.co.sss.crud.entity.Employee;




public class LoginService {


	public boolean login(int id, String password)  {


		Employee loginData = null;
		EmployeeDAO loginDao = new EmployeeDAO();

		//loginに使用するEmployeeテーブルデータを格納する
		loginData = loginDao.findById(id);

		//取得したデータのpasswordと引数で与えられたpasswordがマッチしているか確認する
		if(loginData.getEmpPass().equals(password)){
			return true;
		}


		return false;
	}




}
