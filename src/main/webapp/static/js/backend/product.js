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
	$("#typeName").val($("#typeId :selected").text());
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

function addRow(obj){
	var currentTr = $(obj).parent().parent();
	var html = "<tr>" + currentTr.html() +"</tr>"
	$("#levelPriceTable").append(html);
}

function deleteRow(obj){
	if($("#levelPriceTable tr").length < 3){
		return;
	}
	$(obj).parent().parent().remove();
}

function doAddLevelPrices(){
	var url = "/backend/product/doAddLevelPrices";
	var gameId = $("#gameId").val();
	var startLevel = $("#startLevel").val();
	var endLevel = $("#endLevel").val();
	var price = $("#levelPrice").val();
	var param={"gameId":gameId,"startLevel":startLevel,"endLevel":endLevel,"price":price};
	$.post(url,param,function(data){
		window.location.href = "/backend/product/levelPrice";
	});
}
$("#productImageFile").on("change",function(e){
	$.ajaxFileUpload({
	    url:'/file/upload/product',
	    secureuri:false,                       //是否启用安全提交,默认为false
	    fileElementId:'productImageFile',      //文件选择框的id属性
	    dataType:'json',                       //服务器返回的格式,可以是json或xml等
	    success:function(data, status){        //服务器响应成功时的处理函数
	        $("#productImagePreview").attr("src",data.filePath);
	        $("#productImage").val(data.filePath);
	    },
	    error:function(data, status, e){
	        alert('商品图片上传失败，请重试！！');
	    }
	});
});

function doAddProduct(){
	alert("暂未完成！敬请期待！呵呵呵~~~~~~~~~~~~~~~~~~");
}

$("#priceType").on("change",function(){
	if($("#priceType").val() == 1){
		$("#templeteDiv").removeClass("hidden").addClass("show");
	}
});

$("#needAttrType").on("click",function(){
	
});
