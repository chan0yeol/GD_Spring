// 공통으로 사용하는 jQuery Ajax (공통 모듈)

class Ajax {
	/** 
		setHttpMethod : method type
		setUrl : 요청할 url 매핑주소
		setParam : 요청할 param  
	*/
	constructor() {
		this.httpMethod = "";
		this.url = "";
		this.param = "";
	}
	setHttpMethod(httpMethod) {
		this.httpMethod = httpMethod;
		return this;
	}
	setUrl(url) {
		this.url = url;
		return this;
	}
	setParam(param) {
		this.param = param;
		return this;
	}

	callData() {
		console.log('동작동작:-D:-D:-D:-D:-D:-D', this.httpMethod,this.url);
		var data = "";
		$.ajax({
			url:this.url,
			type:this.httpMethod,
			data:this.param,
			async: false,
			dataType:"JSON",
			success:function(msg) {
				console.log("처리 받은 값", msg);
				data = msg;
			},
			error:function() {
				console.log("잘못된 요청");
			}
		});
		console.log("리턴 data", data);
		return data;
	}
}

export { Ajax }