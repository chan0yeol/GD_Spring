function enterKey() {
	if (window.event.keyCode == 13) {
		loginCheck();
	}
}

window.onload = function() {
	//	document.forms[0].
	document.querySelector("button[type=submit]").onclick = function() {
		console.log("로그인 버튼 클릭");
		event.preventDefault();
		loginCheck();
	}
}

function loginCheck() {
	console.log("로그인 검수");
	var id = document.getElementById('id').value;
	var password = document.getElementById('pwd').value;
	console.log("화면 값 ", id, password);

	var form = document.forms[0];
	form.action = './login.do';
	form.method = 'POST';

	var regex = /^(?=.*\d)(?=.*[a-zA-Z]).{4,}$/;
	var obj = {
		id: id,
		password: password
	}

//	var obj2 = new Object();
//	obj2.id = id;
//	obj2.password = password;
	
	objectData.id = id;
	objectData.password = password;
	
	console.log(obj, typeof obj);	
	console.log(objectData, typeof objectData);
	// TODO 003 test와 match 차이;
	// test는 정규화식을 앞에 작성 정규화.test(string) => 결과 true false
	//  string.match(정규화표현식) => 결과 객체 / null
	// => if문에 사용시 test는 == true 해주는게 좋고 
	//    	match는 null은 if문이 동작되지 않는다. 
	console.log("regEx test", regex.test(id)); // true false로 나옴 
	console.log("regEx match", id.match(regex)); // 안맞으면 null
	
	if(!regex.test(id) && !regex.test(password)){
		alert('4자리 이상 영문과 숫자의 조합이어야 합니다.');
	} else {
		// TODO 004 fetch ajax
		fetch('./loginCheckText.do',{
			method:"POST",
			headers:{
				'Content-Type':'application/json; charset=UTF-8'
			},
			body:
//			JSON.stringify({id:id}) // stringify javascirpt {} 객체통한 전송
//			JSON.stringify(obj)		// 외부에서 javascript Object 객체를 생성해서 전송
			JSON.stringify(objectData) // javascript class를 통한 전송
		})
		.then(response => { // fetch ajax의 실행 결과인 response의 성공을 isOk로 판단하여 처리
							// 성공을 했다면(200) response에 Promise객체로 반환되고 타입 변환을 통해서 함수로 호출
			if(!(response.ok)){ // 200 이 아닌 status 코드를 확인
				console.log("then 1",response)
				console.log("then 1",response.status)
//				return response.text();
//				throw response.text().then(text => {throw new Error(text)});
				// TODO 008 예외처리 javascript 
				return response.json().then(errorData => {
					throw new Error(errorData.message || "알수 없는 오류 입니다.");
				});
			} 
//			else{
				return response.json(); 
//			}
		}) 
		.then(data => { // 성공을 했을 경우, 반환되는 data를 받아서 처리하는 곳
			console.log(data);
			console.log(data.isc);
			if(data == "등록 오류입니다"){
				throw new Error(data);
			} 
			else{
				location.href='./login.do';
			}
		})
		// TODO 00801 예외처리 javascript
		.catch(err => {alert(err.message)});
	}
}














