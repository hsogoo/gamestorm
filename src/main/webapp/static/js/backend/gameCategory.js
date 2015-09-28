$(document).ready(function() {
	//queryForGameCategory(1);
    if ($().select2) {
        $('.select2me').select2({
            placeholder: "Select",
            allowClear: true
        });
    }
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

