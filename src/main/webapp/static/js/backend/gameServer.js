$("#gameId").on("change",function(){
	$("#gameName").val($("#gameId :selected").text());
});

function submitAddGameServer(){
	if($.trim($("#gameId").val()).length < 1){
		alert("请先选择游戏");
		return;
	}
	if($.trim($("#serverName").val()).length < 1){
		alert("请先输入服务器名称");
		return;
	}
    $("#addGameServerForm").submit();
}

function saveGameServer(gameServerId){
    var priceExt = $("input[name='gameServer_"+gameServerId+"']").val();
    var url = "/backend/gameServer/doSaveGameServer";
    var param={"priceExt":priceExt,"id":gameServerId};
    $.post(url,param,function(data){
        window.location.href = "/backend/gameServer/manage";
    });
}

function deleteGameServer(gameServerId){
	window.location.href = "/backend/gameServer/deleteGameServer?id=" + gameServerId;
}

