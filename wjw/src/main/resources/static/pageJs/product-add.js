/**
 * 
 */

$(function(){
	
	queryType();
	
	$(".select-type").change(function(obj){debugger
		queryCategory($(this).val());
	});
});


function queryType(){
	var category_url = CommonVar.app_root+"/product/brand/list";
	$(".select-type").empty();
	$(".select-type").append('<option value="default">请选择</option>');
	$.get(category_url, function(data){
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var ty = data[i];
			var ty_em = '<option value="'+ty.id+'">'+ty.vname+'</option>';
			$(".select-type").append(ty_em);
		}
	});
}

function queryCategory(typeId){
	var category_url = CommonVar.app_root+"/product/category/"+typeId;
	$(".select-category").empty();
	$(".select-category").append('<option value="0">默认</option>');
	$.get(category_url, function(data){
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var cg = data[i];
			var cg_em = '<option value="'+cg.id+'">'+cg.vname+'</option>';
			$(".select-category").append(cg_em);
			
		}
	});
}
