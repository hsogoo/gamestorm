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