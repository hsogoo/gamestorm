function initContentManagePage(page){
	var url = "/backend/content/contentList";
	var typeName = "";
	var typeId = "";
	var param={"page":page,"typeName":typeName,"typeId":typeId};
	$.post(url,param,function(data){
		$("#contentList").html(data);
	});
}

function searchForContent(page){

	queryForContent(page);
}

function queryForContent(page){
	var url = "/backend/user/userList";
	var typeName = "";
	if($("#searchTypeName").length){
		typeName = $("#searchTypeName").val();		
	}
	var typeId = "";
	if($("#searchTypeId").length){
		typeId = $("#searchTypeId").val();
	}
	var param={"page":page,"typeName":typeName,"typeId":typeId};
	$.post(url,param,function(data){
		$("#contentList").html(data);
	});
}

function submitAddContentType() {
	$("#addContentTypeForm").submit();
}

function saveContentType(contentId){
	var typeName = $("input[name='typeName_"+contentId+"']").val();
	var status = $("input[name='status_"+contentId+"']:checked").val();
	var url = "/backend/content/updateContentType";
	var param={"id":contentId,"typeName":typeName,"status":status};
	$.post(url,param,function(data){
		window.location.href = "/backend/content/contentTypeSetting";
	});
}

function doAddContent(){
	var typeId = $("#contentType").val();
	if($.trim(typeId)==""){
		alert("请先选择内容分类");
		return;
	}
	var typeName = $("#contentType :selected").text();
	var url = "/backend/content/doAddContent";
	var title = $("#newsTitle").val();
	if($.trim(title).length < 1){
		alert("标题不能为空");
		return;
	}
	var content = $("#summernote").code();
	if($.trim(content).length < 1){
		alert("内容不能为空");
		return;
	}
	var param={"title":title,"content":content,"typeId":typeId,"typeName":typeName};
	$.post(url,param,function(data){
		window.location.href = "/backend/content/manage";
	});
}
