$(document).ready(function() {
	queryForGame(1);
	
});

function queryForGame(page){
	var url = "/backend/game/gameList";
	var param={"page":page};
	$.post(url,param,function(data){
		$("#gameList").html(data);
	});
}

function submitAddGame(){
	$("#addGameForm").submit();
}
