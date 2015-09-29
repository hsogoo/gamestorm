
function queryForNews(page){
	var url = "/backend/news/newsList";
//	var userName = $("input[name=userName]").val();
//	var userEmail = $("input[name=userEmail]").val();
	var param={"page":page};
	$.post(url,param,function(data){
		$("#newsList").html(data);
	});
}

function doAddNews(){
	var url = "/backend/news/doAddNews";
	var newsTitle = $("#newsTitle").val();
	var newsContent = $("#summernote").code();
	var param={"newsTitle":newsTitle,"newsContent":newsContent};
	$.post(url,param,function(data){
		window.location.href = "/backend/news/manage";
	});
}
