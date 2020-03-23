<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天气数据</title>
<script type="text/javascript" src="${ctx}/static/js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${ctx}/static/js/echarts.min.js"></script>
<script type="text/javascript">

	$(function () {
		
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
		
		$.ajax({
	        url:'${ctx}/ChartServlet',
	        type:'POST',
	        dataType:'json',
	        success:function(data) {
	           alert(data.maxList);
	           alert(data.minList);
	           
	           var option = {
	        		    title : {
	        		        text: '平均气温'
	        		    },
	        		    tooltip : {
	        		        trigger: 'axis'
	        		    },
	        		    legend: {
	        		        data:['最高气温','最低气温']
	        		    },
	        		    toolbox: {
	        		        show : true,
	        		        feature : {
	        		            dataView : {show: true, readOnly: false},
	        		            magicType : {show: true, type: ['line', 'bar']},
	        		            restore : {show: true},
	        		            saveAsImage : {show: true}
	        		        }
	        		    },
	        		    calculable : true,
	        		    xAxis : [
	        		        {
	        		            type : 'category',
	        		            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	        		        }
	        		    ],
	        		    yAxis : [
	        		        {
	        		            type : 'value'
	        		        }
	        		    ],
	        		    series : [
	        		        {
	        		            name:'最高气温',
	        		            type:'bar',
	        		            data:data.maxList,
	        		            markPoint : {
	        		                data : [
	        		                    {type : 'max', name: '最大值'},
	        		                    {type : 'min', name: '最小值'}
	        		                ]
	        		            },
	        		            markLine : {
	        		                data : [
	        		                    {type : 'average', name: '平均值'}
	        		                ]
	        		            }
	        		        },
	        		        {
	        		            name:'最低气温',
	        		            type:'bar',
	        		            data:data.minList,
	        		            markPoint : {
	        		                data : [
	        		                	{type : 'max', name: '最大值'},
	        		                    {type : 'min', name: '最小值'}
	        		                ]
	        		            },
	        		            markLine : {
	        		                data : [
	        		                    {type : 'average', name : '平均值'}
	        		                ]
	        		            }
	        		        }
	        		    ]
	        		};
		        // 使用刚指定的配置项和数据显示图表。
		           myChart.setOption(option);
	        },
	        error:function(error,Msgerror){
	           
	        }
		});
	});
	
</script>
</head>
<body>

<div id="main" style="width: 1500px;height:750px;"></div>

</body>
</html>