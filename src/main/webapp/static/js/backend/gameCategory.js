//$(document).ready(function() {
//	initGameAndCategorySelector();
//});
//
//function queryForGameCategory(page){
//	var url = "/backend/gameCategory/gameCategoryList";
//	var param={"page":page};
//	$.post(url,param,function(data){
//		$("#gameCategroyList").html(data);
//	});
//}
//
//function submitAddGameCategory(){
//	$("#addGameCategoryForm").submit();
//}
//
//function submitAddGameCategory(){
//	$("#addCategoryGameForm").submit();
//}


//初始化游戏和类别下拉选项
//function initGameAndCategorySelector(){
//	$.getJSON("/backend/gameCategory/selectCategorys",function(jsonData){
//			//var selObj = document.getElementById('select2_category');
//			//cleanSelectAndAddNewOptions (selObj,jsonData,0);
//		}
//	);
//	$.getJSON("/backend/gameCategory/selectGames",function(jsonData){
//			//var selObj = document.getElementById('select2_game');
//			//cleanSelectAndAddNewOptions (selObj,jsonData,0);
//		}
//	);
//
//}

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

function addGameCategory(){
	var gameId = $("#game").val();
	if($.trim(gameId).length < 1){
		alert("请先选择游戏");
		return;
	}
	var gameName = $("#game :selected").text();
	var categoryId = $("#category").val();
	if($.trim(categoryId).length < 1){
		alert("请先选择类别");
		return;
	}
	var categoryName = $("#category :selected").text();
	var url = "/backend/gameCategory/addGameCategory";
	var param = {"gameId":gameId,"gameName":gameName,"categoryId":categoryId,"categoryName":categoryName};
	//郁闷啊，为什么这里要加一个断点才能进入controller？？？
	$.getJSON(url,param,function(data){
		if(data.code == "00"){
			window.location.href = "/backend/gameCategory/manage";
		}else{
			alert(data.message);
		}
	});
}
