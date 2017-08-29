$(function(){
	//ajaxLeftMentLoad();
	$('ul.sidebar-menu li a[menuclick=true]').bind('click',function(){
		var href=$(this).attr('href');
		href=href.substring(1);
		refreshBreadcrumbByUrl($(this).attr('href'));
		ajaxRightLoad(href);
	});
	var currentPathHash=location.hash;
	if( typeof(currentPathHash)!='undefined' && location.hash!='' && location.hash!='#'){
		$('ul.sidebar-menu li a[href="'+currentPathHash+'"]').parent().parent().parent().addClass('menu-open');
		$('ul.sidebar-menu li a[href="'+currentPathHash+'"]').parent().parent().css('display','block');
		$('ul.sidebar-menu li a[href="'+currentPathHash+'"]').click();
	}else{
		$('#sidebar').find('ul li:eq(1) a:eq(0)').click();
		refreshBreadcrumbByUrl();
	}
});

function refreshBreadcrumbByUrl(currentPathHash){
	if(typeof(currentPathHash)=='undefined' || currentPathHash==''){
		var currentPathHash=location.hash;
	}
	if(typeof(currentPathHash)!='undefined' && currentPathHash!=''){
		var breadcrumbList=new Array();
		var currentActive=$('ul.sidebar-menu li a[href="'+currentPathHash+'"]');
		var ul=currentActive.parents('ul.sidebar-menu');
		//设置左侧样式
		$('#sidebar li').removeClass('active');
		$('#sidebar li').removeClass('open');
		$(ul).show();	
		$(currentActive).parent().addClass('active').show();	
	}else{
		$('#sidebar li').removeClass('active open');
		$('#sidebar li').eq(0).addClass('active');
	}	
}
function ajaxLeftMentLoad(){
	$.ajax({
		url : '/system/common/leftMenu',
		type: "POST",
		data: '',
		cache : false,
		async:false,
		success : function(html) {
			$('#sidebar').html(html);			
		}
	});			
}

function ajaxRightLoad(url){
	$.ajax({
		url :  url,
		type : "POST",
		data:  '',
		cache : false,
		success : function(html) {
			$('#page-content').html(html);			
		}
	});		
}
