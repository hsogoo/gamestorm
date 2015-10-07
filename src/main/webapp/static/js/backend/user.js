function initUserManagePage(page){
	var url = "/backend/user/userList";
	var userName = "";
	var userEmail = "";
	var param={"page":page,"userName":userName,"userEmail":userEmail};
	$.post(url,param,function(data){
		$("#userList").html(data);
	});
}

function searchForUser(page){
	if($("#searchUserName").length){
		$("#searchUserName").val($("input[name=userName]").val());
	}
	if($("#searchUserEmail").length){
		$("#searchUserEmail").val($("input[name=userEmail]").val());
	}
	queryForUser(page);
}

function queryForUser(page){
	var url = "/backend/user/userList";
	var userName = "";
	if($("#searchUserName").length){
		userName = $("#searchUserName").val();		
	}
	var userEmail = "";
	if($("#searchUserEmail").length){
		userEmail = $("#searchUserEmail").val();
	}
	var param={"page":page,"userName":userName,"userEmail":userEmail};
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
