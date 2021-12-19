<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="sz_rightBody" id="table_box">
	<div id="main" style="width: 100%;height:500px;"></div>
</div>
<script  type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));
	
	// 指定图表的配置项和数据
	var option = {
	    title: {
	        text: '近12个月的月销量统计图'
	    },
	    tooltip: {},
	    legend: {
	        data:['销量']
	    },
	    xAxis: {
	        data: ${jsonxAxis}
	    },
	    yAxis: {},
	    series: [{
	        name: '销量',
	        type: 'bar',
	        data: ${jsonyAxis},
	        label: {
                normal: {
                    show: true,
                    position: 'inside'
                }
            }
	    }]
	};
	
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>
