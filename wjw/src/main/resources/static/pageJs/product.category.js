/**
 * 
 */

$(function(){
	
	queryCategory();
});

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
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
