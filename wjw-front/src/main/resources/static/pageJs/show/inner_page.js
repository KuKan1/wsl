/**
 * 
 */

$(function(){
	$(".category_id").bind("click",loadDataByNoParam);
	var ct_id = $(".inner_nav").find('li').each(function(){
		if($(this).hasClass("inner_con_style")){
			var type_id = $(this).attr("ty-id");
			var category_id = $(this).attr("ct-id");
			loadData(type_id,category_id);
		}
	});
	
});

function loadDataByNoParam(){
	var type_id = $(this).attr("ty-id");
	var category_id = $(this).attr("ct-id");
	doLoadData(type_id,category_id);
}

function loadData(type_id,category_id){
	if(type_id == undefined){
		type_id = $(this).attr("ty-id");
	}
	if(category_id == undefined){
		category_id = $(this).attr("ct-id");
	}
	doLoadData(type_id,category_id)
}

function doLoadData(type_id,category_id){
	var type_url = CommonVar.app_root+"/shop/"+type_id+"/"+category_id;
	$("#sw-shop-list").empty();
	$.get(type_url, function(data){
		var step = 2;
		var len = data.length;
		for (var i = 0; i < len; i+=step) {
			var left_data = data[i];
			var em_left = '<a href="'+left_data.vurl+'">'+
				'<li class="border_right fl">'+
				'<img src="'+CommonVar.img_url+left_data.vcover+'" />'+
				'<span>'+left_data.vname+'</span>'+
				'<span class="int_color">原价: ￥'+left_data.originalPrice+'</span>'+
				'<span class="int_color">券后价: ￥'+left_data.couponPrice+'</span>'+
				'</li>'+
				'</a>';
			$("#sw-shop-list").append(em_left);
			if((i+1) < len){
				var right_data = data[i+1];
				var em_right = '<a href="'+right_data.vurl+'">'+
					'<li class="fl">'+
					'<img src="'+right_data.vcover+'" />'+
					'<span>'+right_data.vname+'</span>'+
					'<span class="int_color">京东价: ￥'+right_data.originalPrice+'</span>'+
					'<span class="int_color">券后价: ￥'+right_data.couponPrice+'</span>'+
					'</li>'+
					'</a>';
				$("#sw-shop-list").append(em_right);
			}
		}
	});
}