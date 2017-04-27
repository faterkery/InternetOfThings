var Website = {
	run: function(){
		oScroll1 = $('#scrollbar1');
		if(oScroll1.length > 0){
			oScroll1.tinyscrollbar();
		}
		var oScroll2 = $('#scrollbar2');
		if(oScroll2.length > 0){
			oScroll2.tinyscrollbar({ axis: 'x' });
		}
		var oScroll2 = $('#scrollbar3');
		if(oScroll2.length > 0){
			oScroll2.tinyscrollbar({ size: 100 });
		}					
		Cufon.replace('h2, h1, a.download');
		
		var oCon = document.getElementById('mcon');
		var oLink = document.createElement('a');
		var oText = document.createTextNode("me"); 
		var sPart0 = 'ma';
		var sPart1 = 'ilto:wie';
		var sPart2 = 'ringen';
		var sPart3 = '@gm';	
		var sPart4 = 'ail.com';
		oLink.href = sPart0+sPart1+sPart2+sPart3+sPart4;
		
		//var ding = document.evaluate("//h2", document, null, 8, null);
		//console.log(ding.singleNodeValue);

		
	}
};


//Initialize
$(document).ready(function(){
	Website.run();
});