/*
	BoardController의 boardList.do를통한 GET을 통한 MPA 방식의 개발
*/

function firstPage() {
	location.href="./boardList.do?page=1";
}

function pagePrev(stagePage, countPage) {
	var page = (stagePage-countPage) < 0 ? 1:(stagePage-countPage);
	location.href="./boardList.do?page="+page;
}

function page(page) {
	location.href="./boardList.do?page="+page;
}

function pageNext(stagePage, countPage) {
	location.href="./boardList.do?page="+(stagePage+countPage);
}

function pageLast(totalPage) {
	location.href="./boardList.do?page="+totalPage;
}