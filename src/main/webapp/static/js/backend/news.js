$(document).ready(function() {
	queryForNews(1);
});

function queryForNews(page){
	var url = "/backend/news/newsList";
//	var userName = $("input[name=userName]").val();
//	var userEmail = $("input[name=userEmail]").val();
	var param={"page":page};
	$.post(url,param,function(data){
		$("#newsList").html(data);
	});
}

