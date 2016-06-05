$(document).ready(function(){
	$(".myform").submit(function(){
	if($('#username').val()==''){
    alert('用户名不能为空！');
	$("#username").focus();
	return false;
	
	}else{
	if($('#phone').val()==''){
		alert('电话不能为空！');
		$("#phone").focus();
		return false;
	}else{
	alert('输入正确！');
	return true;
	}
	}
	});

});