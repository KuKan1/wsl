/**
 * 
 */

$('#but_login').click(function(e) {
	submit();
});


function submit(){
	var submit = true;
	$("input[placeholder]").each(function() {
		if ($("#" + this.name).val() == "") {
			alert($("#" + this.name).attr("placeholder"));
			submit = false;
			return false;
		}
	});
	if (submit) {
		setTimeout("Login()", 1000);
	}
}

//登录处理函数
function Login() {
	var path = getRootPath();
	//setCookie();
	var actionurl=$('form').attr('action');//提交路径
	 var formData = new Object();
	var data=$(":input").each(function() {
		 formData[this.name] =$("#"+this.name ).val();
	});

	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : actionurl,// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			if(data=='suc'){
				if (top.location != location){
					setTimeout("top.location.href = '/index'",1000);
				 }else{
					 setTimeout("window.location.href = '/index'",1000);
				 }
            }else if(data=='error'){
            	alert("登录失败!");
            }
		}
	});
}