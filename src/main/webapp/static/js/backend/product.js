function addProductType(){
	
	if($.trim($("#game").val()).length < 1){
		alert("请先选择游戏");
		return;
	}
	
	if($.trim($("#category").val()).length < 1){
		alert("请先选择类别");
		return;
	}
	
	if($.trim($("#productType").val()).length < 1){
		alert("请输入商品类型");
		return;
	}
	
	var gameName = $("#game :selected").text();
	var gameId = $("#game").val();
	var categoryName = $("#category :selected").text();
	var categoryId = $("#category").val();
	var typeName = $("#productType").val();
	
	var url = "/backend/product/addProductType";
	var param = {"gameId":gameId,"gameName":gameName,"categoryId":categoryId,"categoryName":categoryName,"typeName":typeName};
	$.getJSON(url,param,function(data){
		if(data.code == "00"){
			window.location.href = "/backend/product/type";
		}else{
			alert(data.message);
		}
	});
	
}

function submitAddAttrType(){
	if($.trim($("#typeName").val()).length < 1){
		alert("请输入系列类型名称");
		return;
	}
	$("#addAttrTypeForm").submit();
}

$("#typeId").on("change",function(){
	$("#typeName").val($("#typeId:selected").text());
});

function submitAddAttrValue(){

	if($.trim($("#typeId").val()).length < 1){
		alert("请先选择属性类型");
		return;
	}

	if($.trim($("#attrValue").val()).length < 1){
		alert("请输入系列值名称");
		return;
	}
	$("#addAttrValueForm").submit();
}