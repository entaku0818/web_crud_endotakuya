package jp.co.sss.crud.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dao.DepartmentDAO;
import jp.co.sss.crud.dao.EmployeeDAO;
import jp.co.sss.crud.dto.UserEmpDto;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.ChangeForm;

public class EmployeeService {








	/**
	 * Topページに出力するEmployeeを取得するメソッド
	 * @return
	 */
	public UserEmpDto[] getAllEmpData()  {

		//empDataは更新削除が発生する場合があるため、List
		List<Employee> empEntity = new ArrayList<Employee>();
		EmployeeDAO empDao = new EmployeeDAO();


		//empDataへDaoから取得したデータを格納する
		empEntity = empDao.findAll();

		UserEmpDto[] empDto = new UserEmpDto[empEntity.size()];

		return this.setDtoFromEntity(empDto, empEntity);

	}



	/**
	 *Topページに出力するEmployeeを取得するメソッド
	 * @param findColumn
	 * @param findEmp
	 * @return
	 */
	public UserEmpDto[] getAllEmpData(String findColumn, UserEmpDto findEmp) {

				//empDataは更新削除が発生する場合があるため、List

				List<Employee> empEntity = new ArrayList<Employee>();
				EmployeeDAO empDao = new EmployeeDAO();

				//findColumn の値によって呼び出すDAOのメソッドを変更する
				if(findColumn.equals("empId")){
					empEntity = empDao.findAllById(findEmp.getEmpId());
				}else if(findColumn.equals("empName")){
					empEntity = empDao.findAllByName(findEmp.getEmpName());
				}else if(findColumn.equals("deptName")){
					empEntity = empDao.findAllByDeptId(findEmp.getDeptId());
				}

				UserEmpDto[] empDto = new UserEmpDto[empEntity.size()];

				return setDtoFromEntity(empDto, empEntity);
	}

	/**
	 * updateページに出力するEmployeeを取得するメソッド
	 * @param findColumn
	 * @param findEmp
	 * @return
	 */
	public UserEmpDto getEmpData(String findColumn, UserEmpDto findEmp) {

		//empDataは更新削除が発生する場合があるため、List

		Employee empEntity = new Employee();
		EmployeeDAO empDao = new EmployeeDAO();

		//findColumn の値によって呼び出すDAOのメソッドを変更する
		if(findColumn.equals("empId")){
			empEntity = empDao.findById(findEmp.getEmpId());
		}
		UserEmpDto empDto = new UserEmpDto();

		return setDtoFromEntity(empDto, empEntity);
}







	/**
	 * ユーザーがフォームへ入力したデータを確認するメソッド
	 * @param changeForm
	 * @param empId
	 * @return
	 */
	public UserEmpDto chkInputData(ChangeForm changeForm) {

		UserEmpDto empDto = new UserEmpDto();
		this.setDtoFromForm(empDto, changeForm);



		return empDto ;

	}


	/**
	 * changeFormで受け取ったデータを挿入するメソッド
	 * @param empId
	 * @param ChangeForm
	 * @return
	 */
	public int createData(ChangeForm changeForm ) {

		EmployeeDAO empDao = new EmployeeDAO();
		int count = empDao.insert( this.setEntityFromForm(changeForm) );

		return count;

	}


	public int updateData(ChangeForm changeForm) {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeDAO empDao = new EmployeeDAO();
		int count = empDao.update( this.setEntityFromForm(changeForm) );

		return count;

	}

	public int deleteData(ChangeForm changeForm) {
		// TODO 自動生成されたメソッド・スタブ
		EmployeeDAO empDao = new EmployeeDAO();

		//entityをDaoへ渡す
		int count = empDao.delete( this.setEntityFromForm(changeForm) );

		return count;

	}



	/**
	 *
	 * @param empDto
	 * @param empEntity
	 * @return
	 */
	UserEmpDto[] setDtoFromEntity(UserEmpDto[] empDto, List<Employee> empEntity){

		DepartmentDAO deptDao = new DepartmentDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");



		//Viewへ渡したいデータをempData→empDtoへ入れる
		for(int i =0; i < empEntity.size();i++){



			empDto[i] = new UserEmpDto();
			empDto[i].setEmpId(empEntity.get(i).getEmpId());
			empDto[i].setEmpName(empEntity.get(i).getEmpName());

			if(empEntity.get(i).getGender()==1){
				empDto[i].setGenderName("男");
			}else if(empEntity.get(i).getGender()==2){
				empDto[i].setGenderName("女");
			}

			empDto[i].setAddress(empEntity.get(i).getAddress());
			empDto[i].setBirthday( sdf.format(empEntity.get(i).getBirthday()) );
			if(empEntity.get(i).getAuthority()==1){
				empDto[i].setAuthorityName("一般");
			}else if(empEntity.get(i).getAuthority()==2){
				empDto[i].setAuthorityName("管理");
			}

			// DepartmentDAO経由でDepartmentテーブルから部署名を取得する
			empDto[i].setDeptName( deptDao.findById( empEntity.get(i).getDeptId() ).getDeptName() );


		}


		return empDto;
	}


	/**
	 *
	 * @param empDto
	 * @param empEntity
	 * @return
	 */
	UserEmpDto setDtoFromEntity(UserEmpDto empDto, Employee empEntity){

		DepartmentDAO deptDao = new DepartmentDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");



		//Viewへ渡したいデータをempData→empDtoへ入れる
			empDto.setEmpId(empEntity.getEmpId());
			empDto.setEmpPass(empEntity.getEmpPass());
			empDto.setEmpName(empEntity.getEmpName());
			empDto.setGender(empEntity.getGender());
			if(empEntity.getGender()==1){
				empDto.setGenderName("男");
			}else if(empEntity.getGender()==2){
				empDto.setGenderName("女");
			}

			empDto.setAddress(empEntity.getAddress());
			empDto.setBirthday( sdf.format(empEntity.getBirthday()) );
			if(empEntity.getAuthority()==1){
				empDto.setAuthorityName("一般");
			}else if(empEntity.getAuthority()==2){
				empDto.setAuthorityName("管理");
			}
			empDto.setAuthority(empEntity.getAuthority());

			empDto.setDeptId(empEntity.getDeptId());
			// DepartmentDAO経由でDepartmentテーブルから部署名を取得する
			empDto.setDeptName( deptDao.findById( empEntity.getDeptId() ).getDeptName() );




		return empDto;
	}

	/**
	 * Formから受け取ったデータをEntityへ格納する
	 * @param empDto
	 * @param empEntity
	 * @return
	 */
	Employee setEntityFromForm(ChangeForm changeForm){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");


			Employee empEntity = new Employee();
			empEntity.setEmpId(changeForm.getEmpId());
			empEntity.setEmpPass(changeForm.getEmpPass());
			empEntity.setEmpName(changeForm.getEmpName());
			empEntity.setGender(changeForm.getGender());
			empEntity.setAddress(changeForm.getAddress());
			try {
				empEntity.setBirthday(
						sdf.parse(changeForm.getBirthday())

						);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			empEntity.setAuthority(changeForm.getAuthority());
			empEntity.setDeptId( changeForm.getDeptId() );


		return empEntity;
	}

	/**
	 * Formから受け取ったデータをDtoへ格納する
	 * @param empDto
	 * @param empEntity
	 * @return
	 */
	UserEmpDto setDtoFromForm(UserEmpDto empDto, ChangeForm changeForm){
		DepartmentDAO deptDao = new DepartmentDAO();

			empDto.setEmpId(changeForm.getEmpId());
			empDto.setEmpPass(changeForm.getEmpPass());
			empDto.setEmpName(changeForm.getEmpName());
			empDto.setGender(changeForm.getGender());

			if(changeForm.getGender()==1){
				empDto.setGenderName("男");
			}else if(changeForm.getGender()==2){
				empDto.setGenderName("女");
			}


			empDto.setAddress(changeForm.getAddress());

			empDto.setBirthday(changeForm.getBirthday());

			empDto.setAuthority(changeForm.getAuthority());
			if(changeForm.getAuthority()==1){
				empDto.setAuthorityName("一般");
			}else if(changeForm.getAuthority()==2){
				empDto.setAuthorityName("管理");
			}

			empDto.setEmpName(changeForm.getEmpName());
			empDto.setDeptId( changeForm.getDeptId() );
			// DepartmentDAO経由でDepartmentテーブルから部署名を取得する
			empDto.setDeptName( deptDao.findById( changeForm.getDeptId() ).getDeptName() );


		return empDto;
	}











}
