function findCheck(){

	var findIdMin = 1;
	var findIdMax = 99999;
	var findNameMin = 1;
	var findNameMax = 12;

	var flag = true;

	var errMsg = "";


	// 取得する
	//if (document.getElementById(findId).value < findIdMin || document.getElementById(findId).value > findIdMax){
		errMsg = errMsg + '<font color="red">社員IDは' + findIdMin + '文字以上' + findIdMax + '文字以下で入力してください</font><br>' ;
		flag = false;
	//}




		errMsg = errMsg + document.getElementById() ;






	// 検索する「社員名」の入力をチェック


		errMsg = errMsg + '<font color="red">社員名は' + findNameMin + '文字以上' + findNameMax + '文字以下で入力してください</font><br>';
		flag = false;





		target = document.getElementById("chkFindMsg");
		target.innerHTML = errMsg;
		return flag;

}





function loginCheck(){

	var idMin = 1;
	var idMax = 99999;
	var passwordMin = 1;
	var passwordMax = 15;
	var flag = true;


	 // 「Id」の文字数をチェック
	if(isNaN(!document.loginForm.id.value) || document.loginForm.id.value < idMin || document.loginForm.id.value > idMax ){

		target = document.getElementById("chkIdMsg");
		target.innerHTML =  '<font color="red">idは' + idMin + '文字以上' + idMax + '文字以下で入力してください</font>';
		flag = false;
	}

	// 「パスワード」の入力をチェック
	if(document.loginForm.password.value.length < passwordMin || document.loginForm.password.value.length > passwordMax ){

		target = document.getElementById("chkPasswordMsg");
		target.innerHTML =  '<font color="red">idは' + passwordMin + '文字以上' + passwordMax + '文字以下で入力してください</font>';
		flag = false;

	}


		return flag;



}

