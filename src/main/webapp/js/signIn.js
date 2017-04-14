$(document).ready(function()
{
	// 页面加载时向pageLoad发送请求
	console.log("向pageLoad发送请求");
	$.getScript("pageLoad");
	// $.post("pageLoad");

});
function reset()
{
	// 清空user、pass两个单行文本框
	console.log("清空user，pass文本框");
	$("#user").val("");
	$("#password").val("");
}
// 切换到注册对话框
function changeRegist()
{
	console.log("切换到注册对话框");
	// 隐藏登录用的两个按钮
	$("#loginDiv").hide("500");
	// 显示注册用的两个按钮
	$("#registDiv").show("500");
}
// 处理用户登录的函数
function proLogin()
{
	// 获取user、pass两个文本框的值

	var user = $.trim($("#user").val());
	var password = $.trim($("#password").val());
	if (user == null || user == "" 
		|| password == null|| password =="")
	{
		alert("必须先输入用户名和密码才能登录");
		console.log("hhh");
		return false;
	}
	else
	{
		// 向proLogin发送异步、POST请求
		console.log("proLogin请求");
		$.post("proLogin", $('#user,#password').serializeArray()
			, null , "script");
	}
}
// 处理用户注册的函数
function regist()
{
	// 获取user、pass两个文本框的值
	var user = $.trim($("#user").val());
	var password = $.trim($("#password").val());
	console.log(user);
	console.log(password);
	if (user == null || user == "" || password == null || password =="")
	{
		alert("必须先输入用户名和密码才能注册");
		return false;
	}
	else
	{
		// 向proRegist发送异步、POST请求
		console.log("向proRegist发送请求");
		$.post("proRegist", $('#user,#password').serializeArray()
			, null , "script");
	}
}


// 周期性地获取当前用户、当前页的相片
function onLoadCheckIn()
{
	console.log("周期性获取相片");
	// 向getPhoto发送异步、GET请求
	$.getScript("getCheckIn");
	// 指定1秒之后再次执行此方法
	setTimeout("onLoadCheckIn()", 1000);
}

function changeHasCheckIn()
{
	// 隐藏签到按钮
	$("#notcheckInDiv").hide("500");
	// 显示以签到按钮
	$("#hascheckInDiv").show("500");
}

//签到按钮事件
function checkIn() {
	var date = new Date().getTime();
	var datetime = timetrans(date);
	$.getScript("CheckIn?date=" + datetime)
	changeHasCheckIn();
}



//时间戳转换为时间
function timetrans(date){
	var date = new Date(date*1000);//如果date为10位不需要乘1000
	var Y = date.getFullYear() + '-';
	var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
	var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
	var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
	var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
	return Y+M+D+h+m+s;
}
