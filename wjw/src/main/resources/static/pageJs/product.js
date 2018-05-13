/**
 * 
 */

$(function(){
	var type_id = 0;
	var category_id = 0;
	//查询产品
	queryProduct(type_id,category_id);
	//查询分类
	queryCategory();
});

/**
 * 查询产品
 * @param type_id
 * @param category_id
 */
function queryProduct(type_id,category_id){
	var product_url = CommonVar.app_root+"/product/"+type_id+"/"+category_id;
	$(".table > tbody").empty();
	$.get(product_url, function(data){
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var pd = data[i];
			var isVisible = "已发布";
			if(pd.isVisible == 2){
				isVisible = "已下架";
			}
			var pd_em = '<tr class="text-c va-m">'+
				'<td><input name="" type="checkbox" value=""></td>'+
				'<td>001</td>'+
				'<td>'+
				'<a onClick="product_show("'+pd.vname+'","product-show.html","10001")" href="javascript:;">'+
				'<img width="60" class="product-thumb" src="temp/product/Thumb/6204.jpg">'+
				'</a>'+
				'</td>'+
				'<td class="text-l">'+pd.vname+
				'</td>'+
				'<td class="text-l">'+pd.typeName + ' '+ pd.categoryName+'</td>'+
				'<td><span class="price">'+pd.originalPrice+'</span> 元</td>'+
				'<td><span class="price">'+pd.couponPrice+'</span> 元</td>'+
				'<td class="td-status"><span class="label label-success radius">'+isVisible+'</span></td>'+
				'<td class="td-manage">'+
				'<a style="text-decoration:none" onClick="product_stop(this,"10001")" href="javascript:;" title="下架">'+
				'<i class="Hui-iconfont">&#xe6de;</i>'+
				'</a> '+
				'<a style="text-decoration:none" class="ml-5" onClick="product_edit("产品编辑","product-add.html","10001")" href="javascript:;" title="编辑">'+
				'<i class="Hui-iconfont">&#xe6df;</i>'+
				'</a> '+
				'<a style="text-decoration:none" class="ml-5" onClick="product_del(this,"10001")" href="javascript:;" title="删除">'+
				'<i class="Hui-iconfont">&#xe6e2;</i>'+
				'</a>'+
				'</td></tr>';
			$(".table > tbody").append(pd_em);
		}
	});
}

/**
 * 查询分类 
 **/
function queryCategory(){
	var category_url = CommonVar.app_root+"/product/category/list";
	$.get(category_url, function(data){
		createCategoryTree(data);
	});
}

function createCategoryTree(zNodes){
	var t = $("#treeCatetory");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#catetoryIframe");
	//demoIframe.on("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
}

var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			//var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				//zTree.expandNode(treeNode);
				return false;
			} else {
				$("#catetoryIframe").attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};

