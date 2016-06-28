
/**
 * 検索フォームの文字列チェック
 * @returns {Boolean}
 */
function findCheck(){

	var findIdMin = 1;
	var findIdMax = 99999;
	var findNameMin = 1;
	var findNameMax = 12;

	var flag = true;

	var errMsg = "";


	// 取得する
	if (document.getElementById("empId").checked){
		if (document.getElementById("findId").value < findIdMin || document.getElementById("findId").value > findIdMax){
			errMsg = errMsg + '<font color="red">社員IDは半角数字' + findIdMin + '以上' + findIdMax + 'で入力してください</font><br>' ;

			flag = false;
		}
	}



	// 検索する「社員名」の入力をチェック
		if (document.getElementById("empName").checked){

			if (document.getElementById("findName").value.length < findNameMin || document.getElementById("findName").value.length > findNameMax){
				errMsg = errMsg + '<font color="red">社員名は' + findNameMin + '文字以上' + findNameMax + '文字以下で入力してください</font><br>';
				flag = false;
			}
		}





		target = document.getElementById("chkFindMsg");
		target.innerHTML = errMsg;
		return flag;

}



/**
 *
 * @returns {Boolean}
 */

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
		target.innerHTML =  '<font color="red">パスワードは' + passwordMin + '文字以上' + passwordMax + '文字以下で入力してください</font>';
		flag = false;

	}


		return flag;



}


/**
 *
 */
function changeCheck(){
	var empPassMin = 1;
	var empPassMax = 15;

	var empNameMin = 1;
	var empNameMax = 30;

	var addressMin = 1;
	var addressMax = 30;


	var flag = true;



	 // 「empPass」の文字数をチェック
	if( document.getElementById("empPass").value.length < empPassMin || document.getElementById("empPass").value.length > empPassMax ){

		target = document.getElementById("chkEmpPassMsg");
		target.innerHTML =  '<font color="red">パスワードは' + empPassMin + '文字以上' + empPassMax + '文字以下で入力してください</font>';
		flag = false;
	}

	 // 「empName」の文字数をチェック
	if( document.getElementById("empName").value.length < empNameMin || document.getElementById("empName").value.length > empNameMax ){

		target = document.getElementById("chkEmpNameMsg");
		target.innerHTML =  '<font color="red">社員名は' + empNameMin + '文字以上' + empNameMax + '文字以下で入力してください</font>';
		flag = false;
	}

	// 「address」の文字数をチェック

	 if( document.getElementById("address").value.length < addressMin || document.getElementById("address").value.length > addressMax ){

		target = document.getElementById("chkAddressMsg");
		target.innerHTML =  '<font color="red">住所は' + addressMin + '文字以上' + addressMax + '文字以下で入力してください</font>';
		flag = false;
	}


	  if( !document.getElementById("birthday").value.match(/^\d{4}\/\d{2}\/\d{2}$/)){
			target = document.getElementById("chkBirthdayMsg");
			target.innerHTML =  '<font color="red">日付は「yyyy/MM/dd」形式で入力してください</font>';
			flag = false;
	 }



	return flag;




}

