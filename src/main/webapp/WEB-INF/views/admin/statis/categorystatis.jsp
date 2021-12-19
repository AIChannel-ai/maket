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
		    title : {
		        text: '商品按类别销量统计图',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ${jsonxAxis}
		    },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:${jsonyAxis},
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                },
		                normal:{ 
                            label:{ 
                               show: true, 
                               formatter: '{b} : {c} ({d}%)' 
                            }, 
                            labelLine :{show:true}
                        } 
		            }
		        }
		    ]
		};
	
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>
