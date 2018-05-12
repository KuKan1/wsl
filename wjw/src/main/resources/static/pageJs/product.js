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
	var product_url = CommonVar.app_root+"/"+type_id+"/"+category_id;
	$(".table > tbody").empty();
	$.get(product_url, function(data){
		debugger
		var len = data.length;
		for (var i = 0; i < len; i+=1) {
			var pd = data[i];
			var pd_em = '<tr class="text-c va-m">'+
				'<td><input name="" type="checkbox" value=""></td>'+
				'<td>001</td>'+
				'<td>'+
				'<a onClick="product_show("哥本哈根橡木地板","product-show.html","10001")" href="javascript:;">'+
				'<img width="60" class="product-thumb" src="temp/product/Thumb/6204.jpg">'+
				'</a>'+
				'</td>'+
				'<td class="text-l">'+
				'<a style="text-decoration:none" onClick="product_show("哥本哈根橡木地板","product-show.html","10001")" href="javascript:;">'+
				'<img title="国内品牌" src="static/h-ui.admin/images/cn.gif"> '+
				'<b class="text-success">圣象</b> 哥本哈根橡木地板KS8373'+
				'</a>'+
				'</td>'+
				'<td class="text-l">原木的外在,实木条形结构,色泽花纹自然,写意;款式设计吸取实木地板的天然去雕饰之美,在视觉上给人带来深邃联想.多款产品适合搭配不同的风格的室内装饰;功能流露出尊贵典雅的大气韵味。</td>'+
				'<td><span class="price">356.0</span> 元/平米</td>'+
				'<td class="td-status"><span class="label label-success radius">已发布</span></td>'+
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
	var category_url = CommonVar.app_root+"/category/list";
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

