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
function saveCategory(categoryId){
	var status = $("input[name='"+categoryId+"_category.status"+"']:checked").val();
	var categoryName = $("input[name='"+categoryId+"_category.categoryName"+"']").val();
	var url = "/backend/category/doSaveCategory";
	var param={"category.status":status,"category.categoryName":categoryName,"category.id":categoryId};
	$.post(url,param,function(data){
		window.location.href = "/backend/category/manage";
	});
}