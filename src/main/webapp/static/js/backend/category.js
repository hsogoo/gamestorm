$(document).ready(function() {
	queryForCategory(1);
});

function queryForCategory(page){
	var url = "/backend/category/categoryList";
	var param={"page":page};
	$.post(url,param,function(data){
		$("#categoryList").html(data);
	});
}

function addCategory(){
	window.location.href = "/backend/category/addCategory";
}

function submitAddCategory(){
	$("#addGameForm").submit();
}

function cancelAddCategory(){
	window.location.href = "/backend/category/manage";
}
