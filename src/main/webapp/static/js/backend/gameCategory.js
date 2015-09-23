$(document).ready(function() {
	//queryForGameCategory(1);
	
});

function queryForGameCategory(page){
	var url = "/backend/gameCategory/gameCategoryList";
	var param={"page":page};
	$.post(url,param,function(data){
		$("#gameCategroyList").html(data);
	});
}

function submitAddGameCategory(){
	$("#addGameCategoryForm").submit();
}

function submitAddGameCategory(){
	$("#addCategoryGameForm").submit();
}

