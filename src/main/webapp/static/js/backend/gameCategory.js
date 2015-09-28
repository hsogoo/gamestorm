$(document).ready(function() {
	initGameAndCategorySelector();
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


//初始化游戏和类别下拉选项
function initGameAndCategorySelector(){
	$.getJSON("/backend/gameCategory/selectCategorys",function(jsonData){
			//var selObj = document.getElementById('select2_category');
			//cleanSelectAndAddNewOptions (selObj,jsonData,0);
		}
	);
	$.getJSON("/backend/gameCategory/selectGames",function(jsonData){
			//var selObj = document.getElementById('select2_game');
			//cleanSelectAndAddNewOptions (selObj,jsonData,0);
		}
	);

}

///*清除select的所有选择项，并添加新的选择项*/
//function cleanSelectAndAddNewOptions(selectObj,dataArray,flagValue){
//	selectObj.options.length = 0;
//	selectObj.options.add(new Option("All",""));
//	for(var i = 0 ; i < dataArray.length; i ++){
//		//if(flagValue == 1){
//		//	selectObj.options.add(new Option(dataArray[i].storeName,dataArray[i].storeID));
//		//}else if(flagValue == 0){
//			selectObj.options.add(new Option(dataArray[i],dataArray[i]));
//		//}
//	}
//}
