/**
 * 
 */

$(function(){
	
	queryType();
	
	$(".select-type").change(function(obj){
		queryCategory($(this).val());
	});
	
	var is_visible = $("#is_visible").val();
	if(is_visible == 'Y'){
		$("#isVisible").attr("checked","checked");
	}
	var is_good = $("#is_good").val();
	if(is_good == 'Y'){
		$("#isGood").attr("checked","checked");
	}
	
});


function queryType(){
	var category_url = CommonVar.app_root+"/brand/list";
	$(".select-type").empty();
	$(".select-type").append('<option value="0">请选择</option>');
	$.get(category_url, function(data){
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var ty = data[i];
			var ty_em = '<option value="'+ty.id+'">'+ty.vname+'</option>';
			$(".select-type").append(ty_em);
		}
		//是否编辑页，赋值
		var type_id = $("#type_id").val();
		if(type_id != null && type_id != ''){
			$("#typeId").val(type_id);
			queryCategory(type_id);
		}
	});
}

function queryCategory(typeId){
	var category_url = CommonVar.app_root+"/category/"+typeId;
	$(".select-category").empty();
	$(".select-category").append('<option value="0">默认</option>');
	$.get(category_url, function(data){
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var cg = data[i];
			var cg_em = '<option value="'+cg.id+'">'+cg.vname+'</option>';
			$(".select-category").append(cg_em);
		}
		//是否编辑页，赋值
		var category_id = $("#category_id").val();
		if(category_id != null && category_id != ''){
			$("#categoryId").val(category_id);
		}
	});
}


/**
 * 保存草稿
 */
function article_save(){
	$('#form-article-add').ajaxSubmit(      //ajax方式提交表单  
            {  
                url: '/product/save',  
                type: 'post',  
                dataType: 'json',  
                beforeSubmit: function () {},  
                success: function (data, status, xhr) {  
                	layer.msg(data.msg);
                }, 
                error: function(data, status, xhr){
                	layer.msg(data.msg);
                },
                clearForm: false,//禁止清楚表单  
                resetForm: false //禁止重置表单  
            });  
}

