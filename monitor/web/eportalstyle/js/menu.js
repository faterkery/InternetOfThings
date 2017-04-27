var mouseover_tid = [];
var mouseout_tid = [];
	$(document).ready(function(){
		$('li.mainlevel').each(function(index){ 	
			$(this).hover(function(){		
			var _self = this; 		
			clearTimeout(mouseout_tid[index]); 			
			mouseover_tid[index] = setTimeout(function() { 	
					$(_self).find('ul').slideDown(200); 		
			}, 150);},
			function(){
				var _self = this; 				 		
				clearTimeout(mouseover_tid[index]); 		
				mouseout_tid[index] = setTimeout(function() { 			
					$(_self).find('ul').slideUp(200);
				}, 200);
			}   		
    ); 	
});
});