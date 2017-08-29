$(function(){
//	$(document).ajaxStart(function(){
//		 $( "#loading").show();
//	});
//	$(document).ajaxStop(function(){
//		$( "#loading").hide();
//	});
});
$.ajaxSetup({
	contentType: "application/x-www-form-urlencoded; charset=utf-8",
	//fixed ajax request body content(json) issue
	headers: {"_isAjax":"true"}
});

//------------------------
//ajax 处理全局异常和session过期问题
var _overrideAjax = true;
(function overrideJQeuryAjax(){
	if(!_overrideAjax){
		return;
	}
	var oriAjax = $.ajax;
	// Override jquery ajax to check if session is valid.
	$.ajax = function(options) {
		var dataType = options.dataType;
		var overrideDefault=options.overrideDefault;
		if(typeof(overrideDefault)=='undefined'){
			overrideDefault=false;
		}
		var callback = options["callback"];
		var oriSuccess = options["success"];
		if ($.isFunction(oriSuccess)) {
			options["success"] = function(result) {
				if (!overrideDefault && !_checkSessionTimeout(result)) {
					//ajax session过期刷新当前页面501
					window.location.href=window.location.href;
					return false;
				}
				if (!overrideDefault && !_checkAuthDenied(result)) {
					//没有权限 401
					dialogOk('抱歉！您没有该操作的权限');
					return false;
				}
				if (!overrideDefault && !_checkAjaxError(result)) {
					//全局异常500
					dialogOk('系统繁忙，请稍后重试');
					return false;
				}
				oriSuccess(result);
			};
		}
		var oriComplete = options["complete"];
		if ($.isFunction(oriComplete)) {
			options["complete"] = function(xmlHttpRequest, textStatus) {
				var result = xmlHttpRequest.responseText;
				if (!overrideDefault && !_checkSessionTimeout(result, dataType)) {
					window.location.href=window.location.href;
					return false;
				}
				oriComplete(xmlHttpRequest, textStatus);
			};
		}	
		//if error function is undefined, set default logic
		var orierror = options["error"];		
		if (!$.isFunction(orierror)) {
			options["error"] = function(err) {
				dialogOk('系统繁忙，请稍后重试');
			};
		}		
		oriAjax(options);
	};
})();

function _checkSessionTimeout(result){
	var flag = true;	
	if(typeof(result)!='undefined' && result==501){
		flag = false;
	}
	return flag;
}
function _checkAuthDenied(result){
	var flag = true;	
	if(typeof(result)!='undefined' && result==401){
		flag = false;
	}
	return flag;
}
function _checkAjaxError(result){
	var flag = true;	
	if(typeof(result)!='undefined' && result==500){
		flag = false;
	}
	return flag;
}
//-------------------

//确认框
function dialogConfirm(message,fun){
	$('#dialogConfirmModalBody').text(message);
	
	$('#dialogConfirmokbutton').bind('click',function(){
		$('#dialogConfirmModal').modal('hide');
		if($.isFunction(fun)){
			fun();
		}
		$('#dialogConfirmokbutton').unbind('click');
	});
	$('#dialogConfirmModal').modal('show');

}
//信息提示框
function dialogOk(message,fun){
	$('#dialogOKModalBody').text(message);
	$('#dialogOKbutton').bind('click',function(){
		$('#dialogOKModal').modal('hide');
		if($.isFunction(fun)){
			fun();
		}
		$('#dialogOKbutton').unbind('click');
	});
	$('#dialogOKModal').modal('show');
}

function ajaxActionConfirm(url,params,message,funcall){
	dialogConfirm(message, function() {
		ajaxRequestFormData(url, params, function(data) {
			if (data.code == 200) {
				if($.isFunction(funcall)){
					funcall(data);
				}
			} else {
				dialogOk(data.message);
			}
		});
	});
}

function ajaxRequestJsonDate(url,params,callBack,extraData){
	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data :  JSON.stringify(params),
		cache:false,
		contentType : 'application/json;charset=utf-8',
		success : function(data) {
			callBack(data,params,extraData);	
		}
	});
}

function ajaxRequestFormData(url,params,callBack,extraData){
	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data :  params,
		cache:false,
		success : function(data) {
			callBack(data,params,extraData);	
		}
	});
}

function ajaxGetRequestFormData(url,params,callBack,extraData){
	$.ajax({
		url : url,
		type : "GET",
		async : false,
		data :  params,
		cache:false,
		success : function(data) {
			callBack(data,params,extraData);	
		}
	});
}

function ajaxAutoRequestFormData(id,callBack){
	var url=$('#'+id).attr('action');
	var params=$('#'+id).serialize();
	$.ajax({
		url : url,
		type : "POST",
		async : false,
		data :  params,
		dataType:'json',
		cache:false,
		success : function(data) {
			if($.isFunction(callBack)){
				callBack(data);					
			}else{
				go_href(window.location.href);
			}
		}
	});
}

function go_href(url){
	window.location.href=url;
}

function auto_href(){
	window.location.href=window.location.href;
}
// from to object
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

//ajx 分页方法 开始
function ajaxPagingLoad(formId,pagenum,pagesize){
	if(typeof(pagenum)=='undefined'){
		pagenum=$('#pagenum').val();
	}
	if(typeof(pagesize)=='undefined'){
		pagesize=$('#pagesize').val();
	}
	if(typeof(pagenum)=='undefined'){
		pagenum=$('#formId').attr('pagenum');
	}
	if(typeof(pagesize)=='undefined'){
		pagesize=$('#formId').attr('pagesize');
	}
	if(typeof(pagenum)=='undefined'){
		pagenum=1;
	}
	if(typeof(pagesize)=='undefined'){
		pagesize=30;
	}
	var contentType=$('#'+formId).attr('contentType');
	if(typeof(contentType)=='undefined'){
		contentType='text';		
	}	
	
	//ajax load html 放置位置
	var ajaxDivId=$('#'+formId).attr('ajaxDivId');
	var url=$('#'+formId).attr('action')+"?pagenum="+pagenum+"&pagesize="+pagesize;
	
	var extraData={formId:formId,ajaxDivId:ajaxDivId};
	if(contentType=='text'){
		var params=$('#'+formId).serialize();		
		ajaxRequestFormData(url,params,ajaxPagingCallBack,extraData);
	}else{
		var params=$('#'+formId).serializeObject();	
		ajaxRequestJsonDate(url,params,ajaxPagingCallBack,extraData);
	}
	
}

function ajaxPagingCallBack(html,params,extraData){	
	var ajaxLoadContent=extraData.ajaxDivId;	
	$('#'+ajaxLoadContent).html(html);	
}

function pageselectCallback(form_id,pagenum,pagesize){
	ajaxPagingLoad(form_id,pagenum,pagesize);	
}