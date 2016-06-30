package jp.co.sss.crud.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jp.co.sss.crud.dto.SysDataDto;

public class SysDataImport {

	/**
	 *
	 * @return config読み込み結果
	 */
	public SysDataDto confImport() {

	       Properties properties = new Properties();
	       SysDataDto sysDataDto = new SysDataDto();

		try{
		      File file = new File("C:\\pleiades\\workspace\\web_crud_endotakuya\\WebContent\\conf\\employee.conf");


		      if (checkBeforeReadfile(file)){
		    	InputStream inputStream = new FileInputStream(file);


		    	properties.load(inputStream);
		    	//Database
		        sysDataDto.setDatabaseConnect( properties.getProperty("DB_Connect") );
		        sysDataDto.setDatabaseUser( properties.getProperty("DB_User") );
		        sysDataDto.setDatabasePassword( properties.getProperty("DB_Password") );
		        sysDataDto.setDatabaseDriver( properties.getProperty("DB_Driver") );

		        //SQL読み込み
		        sysDataDto.setDeptFindAll( properties.getProperty("deptFindAll") );
		        sysDataDto.setDeptFindById( properties.getProperty("deptFindById") );

		        sysDataDto.setEmpFindAll( properties.getProperty("empFindAll") );
		        sysDataDto.setEmpFindAllById( properties.getProperty("empFindAllById") );
		        sysDataDto.setEmpFindAllByName( properties.getProperty("empFindAllByName") );
		        sysDataDto.setEmpFindAllByDeptId( properties.getProperty("empFindAllByDeptId") );
		        sysDataDto.setPagingSQL( properties.getProperty("pagingSQL") );
		        sysDataDto.setEmpFindById( properties.getProperty("empFindById") );
		        sysDataDto.setEmpInsert( properties.getProperty("empInsert") );
		        sysDataDto.setEmpUpdate( properties.getProperty("empUpdate") );
		        sysDataDto.setEmpDelete( properties.getProperty("empDelete") );





		    	String[] columns = properties.getProperty("EmployeeColumns").split(",");


	    		sysDataDto.setEmployeeColumns( columns );









		      }else{
		        System.err.println("ファイルが見つからないか開けません");
		      }
		    }catch(FileNotFoundException e){
		      System.out.println(e);
		    }catch(IOException e){
		      System.out.println(e);
		    }


		return sysDataDto;

	}





	/**
	 * 定義ファイルの存在確認
	 * @param file
	 * @return true or false
	 */
	 private static boolean checkBeforeReadfile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canRead()){
		        return true;
		      }
		    }

		    return false;
		  }



	}


