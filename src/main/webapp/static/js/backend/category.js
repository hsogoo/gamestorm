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