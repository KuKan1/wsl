/**
 * 
 */

$(function(){
	
	onloadNav();
});

var CommonVar={
	app_root:"http://192.168.0.101:8082"
}

function onloadNav(){
	var type_url = CommonVar.app_root+"/type/all";
	$.get(type_url, function(data){
		for (var i = 0; i < data.length; i++) {
			var type = data[i];
			var em_a = '<a href="mesh/Inner_page/'+type.id+'">';
			var em_img = em_a+'<img src="images/'+type.vshort+'.png" />';
			var em_span = em_img+'<span>'+type.vname+'</span>';
			var em =em_span+ '</a>';
			$("#index_lan").append(em);
		}
	});
	
}