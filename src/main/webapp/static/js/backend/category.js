function submitAddCategory(){
	$("#addCategoryForm").submit();
}

function saveCategory(categoryId){
	var status = $("input[name='status_"+categoryId+"']:checked").val();
	var categoryName = $("input[name='categoryName_"+categoryId+"']").val();
	var url = "/backend/category/doSaveCategory";
	var param={"status":status,"categoryName":categoryName,"id":categoryId};
	$.post(url,param,function(data){
		window.location.href = "/backend/category/manage";
	});
}
