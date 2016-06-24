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
import jp.co.sss.crud.form.TopForm;

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
	 *Topページに出力するEmployeeの検索結果を取得するメソッド
	 * @param findColumn
	 * @param topForm
	 * @return
	 */
	public UserEmpDto[] getAllEmpData(String findColumn, TopForm topForm) {

				//empDataは更新削除が発生する場合があるため、List

				List<Employee> empEntity = new ArrayList<Employee>();
				EmployeeDAO empDao = new EmployeeDAO();

				//findColumn の値によって呼び出すDAOのメソッドを変更する
				if(findColumn.equals("empId")){
					empEntity = empDao.findAllById(topForm.getFindId());
				}else if(findColumn.equals("empName")){
					empEntity = empDao.findAllByName(topForm.getFindName());
				}else if(findColumn.equals("deptName")){
					empEntity = empDao.findAllByDeptId(topForm.getFindDeptId());
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
	 * @return　empDto
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
	 * @return 挿入件数
	 */
	public int createData(ChangeForm changeForm ) {
		EmployeeDAO empDao = new EmployeeDAO();
		int count = 0;
		count = empDao.insert( this.setEntityFromForm(changeForm) );

		return count;

	}

	/**
	 * changeFormで受け取ったデータを更新するメソッド
	 * @param ChangeForm
	 * @return 更新件数
	 */
	public int updateData(ChangeForm changeForm) {
		EmployeeDAO empDao = new EmployeeDAO();
		int count = 0;
		count = empDao.update( this.setEntityFromForm(changeForm) );

		return count;

	}

	/**
	 * TopFormで受け取ったデータを更新するメソッド
	 * @param empId
	 * @return　削除件数
	 */
	public int deleteData(int empId,int userId) {
		EmployeeDAO empDao = new EmployeeDAO();
		int count = 0;

			//entityをDaoへ渡す
			count = empDao.deleteById(empId);

		return count;
	}



	/**
	 *	Entityへ格納されているデータをDtoへ格納する
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

			empDto[i].setGenderName( this.getGenderName( empEntity.get(i).getGender() ) );


			empDto[i].setAddress(empEntity.get(i).getAddress());
			empDto[i].setBirthday( sdf.format(empEntity.get(i).getBirthday()) );

			empDto[i].setAuthorityName( this.getAuthorityName(empEntity.get(i).getAuthority()) );

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
			empDto.setGenderName( this.getGenderName(empEntity.getGender() ) );

			empDto.setAddress(empEntity.getAddress());
			empDto.setBirthday( sdf.format(empEntity.getBirthday()) );

			empDto.setAuthorityName( this.getAuthorityName(empEntity.getAuthority()) );

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
			empDto.setGenderName( this.getGenderName(changeForm.getGender() ) );
			empDto.setAddress(changeForm.getAddress());
			empDto.setBirthday(changeForm.getBirthday());
			empDto.setAuthority(changeForm.getAuthority());
			empDto.setAuthorityName( this.getAuthorityName(changeForm.getAuthority()) );
			empDto.setEmpName(changeForm.getEmpName());
			empDto.setDeptId( changeForm.getDeptId() );
			// DepartmentDAO経由でDepartmentテーブルから部署名を取得する
			empDto.setDeptName( deptDao.findById( changeForm.getDeptId() ).getDeptName() );


		return empDto;
	}



	/**
	 *
	 * @param authority
	 * @return
	 */
	private String getAuthorityName(int authority) {

		if(authority == 1){
			return "一般";
		}else if(authority == 2){
			return "管理";
		}

		return null;
	}

	private String getGenderName(int gender) {

		if(gender == 1){
			return "男";
		}else if(gender == 2){
			return "女";
		}

		return null;
	}











}
