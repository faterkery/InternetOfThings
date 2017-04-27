$(function(){	
		   
	//设计案例切换
	$('.title-list li').mouseover(function(){
		var liindex = $('.title-list li').index(this);
		$(this).addClass('on').siblings().removeClass('on');
		$('.company-wrap div.company_con').eq(liindex).fadeIn(0).siblings('div.company_con').hide();
		var liWidth = $('.title-list li').width();
		$('.companys .title-list p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},0);
	});
	
});