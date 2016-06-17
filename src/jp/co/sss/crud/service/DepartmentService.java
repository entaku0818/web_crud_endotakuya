package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.dao.DepartmentDAO;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.entity.Department;


public class DepartmentService {

	public UserEmpDto[] getUserEmpDto()  {

		//deptDataは更新削除が発生する場合があるため、List
		List<Department> deptData = null;
		DepartmentDAO deptDao = new DepartmentDAO();

		deptData = deptDao.findAll();


		UserEmpDto[] deptDto = new UserEmpDto[deptData.size()];


		//Viewへ渡したいデータをempData empDto
		for(int i =0; i<deptData.size();i++){

			deptDto[i] = new UserEmpDto();
			deptDto[i].setDeptId(deptData.get(i).getDeptId());
			deptDto[i].setDeptName(deptData.get(i).getDeptName());


		}


		return deptDto;
	}



}
