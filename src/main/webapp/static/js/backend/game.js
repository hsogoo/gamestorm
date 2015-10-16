function submitAddGame(){
	if($.trim($("#gameName").val()).length < 1){
		alert("请先输入游戏名称");
		return;
	}
	if($.trim($("#iconImage").val()).length < 1){
		alert("请先上传游戏小图标");
		return;
	}
	if($.trim($("#displayImage").val()).length < 1){
		alert("请先上传游戏展示图片");
		return;
	}
	if($.trim($("#bannerImage").val()).length < 1){
		alert("请先上传游戏广告图片");
		return;
	}
	$("#addGameForm").submit();
}

$("#iconImageFile").on("change",function(e){
		$.ajaxFileUpload({
		    url:'/file/upload/game',
		    secureuri:false,                       //是否启用安全提交,默认为false
		    fileElementId:'iconImageFile',           		//文件选择框的id属性
		    dataType:'json',                       //服务器返回的格式,可以是json或xml等
		    success:function(data, status){        //服务器响应成功时的处理函数
		        $("#iconImagePriview").attr("src",data.filePath);
		        $("#iconImage").val(data.filePath);
		    },
		    error:function(data, status, e){ 
		        alert('游戏小图标上传失败，请重试！！');
		    }
		});
});

$("#displayImageFile").on("change",function(e){
	$.ajaxFileUpload({
	    url:'/file/upload/game',
	    secureuri:false,
	    fileElementId:'displayImageFile',
	    dataType:'json',
	    success:function(data, status){
	        $("#displayImagePriview").attr("src",data.filePath);
	        $("#displayImage").val(data.filePath);
	    },
	    error:function(data, status, e){
	        alert('展示图片上传失败，请重试！！');
	    }
	});
});

$("#bannerImageFile").on("change",function(e){
	$.ajaxFileUpload({
	    url:'/file/upload/game',
	    secureuri:false, 
	    fileElementId:'bannerImageFile',
	    dataType:'json',
	    success:function(data, status){
	        $("#bannerImagePriview").attr("src",data.filePath);
	        $("#bannerImage").val(data.filePath);
	    },
	    error:function(data, status, e){
	        alert('广告图片上传失败，请重试！！');
	    }
	});
});