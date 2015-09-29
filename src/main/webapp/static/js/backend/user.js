$(document).ready(function() {
	queryForUser(1);
});

function queryForUser(page){
	var url = "/backend/user/userList";
	var param={"page":page};
	$.post(url,param,function(data){
		$("#userList").html(data);
	});
}

function submitAddUserLevel() {
	$("#addUserLevelForm").submit();
}

function saveUserLevel(levelId){
	var levelName = $("input[name='levelName_"+levelId+"']").val();
	var orderAmount = $("input[name='orderAmount_"+levelId+"']").val();
	var levelDiscount = $("input[name=levelDiscount_"+levelId+"']").val();
	var url = "/backend/user/doSaveUserLevel";
	var param={"levelName":levelName,"orderAmount":orderAmount,"id":levelDiscount};
	$.post(url,param,function(data){
		window.location.href = "/backend/user/levelSetting";
	});
}
