$(document).ready(function() {
	//
	ComponentsPickers.init();
	queryForUser(1);
});

function queryForUser(page){
	var url = "/backend/orderList";
	var param={"page":page};
	$.post(url,param,function(data){
		$("#orderList").html(data);
	});
}