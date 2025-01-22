function handle_ajax(page) {
	spa_handle_ajax(page);
}

var spa_handle_ajax = (choice_page) => {
	
	//TODO 01602 handlebars 정의
	// HandlebarsJS에서는 Handlebars 객체를 가지고 있다.
	// Handlebars에 registHelper에 이벤트를 작성하면 template을 컴파일시 안에서 이벤트를 사용할 수 있다.
	
	// Handlebars 헬퍼 등록
	// 날짜 변경 formatDate
	Handlebars.registerHelper("formatDate", (timestamp) =>{
		const date = new Date(timestamp);
		return `${date.getFullYear()} 년 ${date.getMonth()+1}월 ${date.getDate()}일`
	});
	// include
	Handlebars.registerHelper("contains", (str,substring) => {
		return str.includes(substring);
	});
	// replace 
	Handlebars.registerHelper("replace", (str,search,replacement) =>{
		return str.replace(new RegEx(search,'g'),replacement);
	});
	// equals
	Handlebars.registerHelper("equals", (a,b) => {
		return a === b;
	});
	// or 
	Handlebars.registerHelper("or", (a,b) =>{
		return a||b;
	});
	
	
	
	$.ajax({
		url: "./page.do",
		method: "POST",
		data: { page: choice_page },
		dataType: "json",
		success : (data) =>{
			console.log(data);
			const templateSource = document.getElementById('table-template').innerHTML;
			const template = Handlebars.compile(templateSource);
			const context = {
				lists:data.lists,
				memId:data.memId,
				showCheckBox: data.auth == 'A',
				colspan : data.auth == 'A'?6:4,
				hasPrevStage : data.row.stagePage > 1,
				hasPrevPage : data.row.stagePage - data.row.countPage >= 0,
				hasNextPage : data.row.page < data.row.totalPage,
				hasNextStage : data.row.stagePage + data.row.countPage < data.row.totalPage,
				stagePage : data.row.stagePage,
				countPage : data.row.countPage,
				totalPage : data.row.totalPage,
				pages : Array.from({length:data.row.endPage-data.row.stagePage + 1}, (_,i) => ({
					page:data.row.stagePage + i,
					isActive:data.row.page === data.row.stagePage + i,
				})),
				auth : data.auth
			};
			console.log(context);
			const html = template(context);
			$('.table').html(html);
//			$('.table').append(html);
			
		},
		error : () => {
			alert('잘못된 요청 처리');
		}
	});
}

function firstPage() {
	console.log("첫 페이지 이동")

}

function pagePrev(stagePage, countPage) {
	var page = (stagePage - countPage) < 0 ? 1 : (stagePage - countPage);
	console.log("페이지 그룹 이전 이동")
}

function page(page) {
	console.log("선택된 페이지 이동")
	handle_ajax(page);
}

function pageNext(stagePage, countPage) {
	console.log("페이지 그룹 이후 이동")
}

function pageLast(totalPage) {
	console.log("마지막 페이지 이동")
}