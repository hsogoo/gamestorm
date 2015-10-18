function submitAddGameServer(){
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