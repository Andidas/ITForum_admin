//传统方法定义js类
var replyTableInit = function() {
	//初始化Table(用this定义的是公有方法或属性)
	this.Init = function() {
		$("#replyTable").bootstrapTable({
			url : "../session/getReplyPage.htm", //请求后台的URL（*）
			method : "get", //请求方式（*）
			//如果使用post，contentType默认用json发送数据，java后台无法通过getParameter获取参数
			//contentType : "application/x-www-form-urlencoded",
			toolbar : ".btn-toolbar", //工具按钮用哪个容器
			striped : false, //是否显示行间隔色
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			sortable : true, //是否启用排序
			sortName : "rid", //排序的字段
			sortOrder : "asc", //排序方式
			queryParamsType : "limit", //采用restful风格发送数据
			queryParams : queryParams,//传递参数（*）
			//设置为其他，可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
			//设置为limit可以获取limit, offset, search, sort, order  
			pagination : true, //是否显示分页（*）
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, //初始化加载第一页，默认第一页
			pageSize : 5, //每页的记录行数（*）
			pageList : [ 5, 10, 25, 50, 100 ], //可供选择的每页的行数（*）
			silentSort : true, //分页时自动记住排序
			//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//strictSearch : false,   //false是模糊搜索，true是精确搜索
			showColumns : true, //是否显示所有的列
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行
			//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "rid", //每一行的唯一标识，一般为主键列
			showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			//detailView : false, //是否显示父子表
			columns : [ { //配置列属性
				checkbox : true
			}, {
				field : "rid",
				title : "编号",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}, {
				field : "rsid",
				title : "版块编号",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}, {
				field : "rtid",
				title : "帖子编号",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}, {
				field : "ruid",
				title : "回复人",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}, {
				field : "rcontent",
				title : "内容",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}, {
				field : "rtime",
				title : "发表时间",
				align : "center",
				valign : "middle",
				sortable : true
				// 开启排序功能
			}],
			responseHandler : function(res) {

				return {
					"total" : res.datas.total,//总记录数
					"rows" : res.datas.list
					//数据
				};
			}
		});
	};

	//得到查询的参数(用var定义的是私有方法或属性)
	var queryParams = function(params) {
		var paramdata = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				pageSize : params.limit, //页面大小
				pageNum : params.offset, //页码
				//search: params.search,  //搜索框
				sort : params.sort, //排序字段
				order : params.order,
				info :$("#queryReply_input").val()
				
				//排序方式
		};
		return paramdata;
	};
};

