<%--
  Created by IntelliJ IDEA.
  User: katiemi
  Date: 2016/11/7
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<script src="${pageContext.request.contextPath}/echart/echarts.min.js"></script>

<body>
<div id="div_echart_2" style="width: 100%;height:80%;"></div>
</body>
<script>
    var myChart = echarts.init(document.getElementById('div_echart_2'));
    myChart.showLoading();
    $.get('http://www.echartsjs.com/gallery/data/asset/data/confidence-band.json', function (data) {
        myChart.hideLoading();
        var base = -data.reduce(function (min, val) {
            return Math.floor(Math.min(min, val.l));
        }, Infinity);
        myChart.setOption(option = {
            title: {
                text: 'Confidence Band',
                subtext: 'Example in MetricsGraphics.js',
                left: 'center'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    animation: false,
                    label: {
                        backgroundColor: '#ccc',
                        borderColor: '#aaa',
                        borderWidth: 1,
                        shadowBlur: 0,
                        shadowOffsetX: 0,
                        shadowOffsetY: 0,
                        textStyle: {
                            color: '#222'
                        }
                    }
                },
                formatter: function (params) {
                    return params[2].name + '<br />' + params[2].value;
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                data: data.map(function (item) {
                    return item.date;
                }),
                axisLabel: {
                    formatter: function (value, idx) {
                        var date = new Date(value);
                        return idx === 0 ? value : [date.getMonth() + 1, date.getDate()].join('-');
                    }
                },
                splitLine: {
                    show: false
                },
                boundaryGap: false
            },
            yAxis: {
                axisLabel: {
                    formatter: function (val) {
                        return (val - base) * 100 + '%';
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return ((params.value - base) * 100).toFixed(1) + '%';
                        }
                    }
                },
                splitNumber: 3,
                splitLine: {
                    show: false
                }
            },
            series: [{
                name: 'L',
                type: 'line',
                data: data.map(function (item) {
                    return item.l + base;
                }),
                lineStyle: {
                    normal: {
                        opacity: 0
                    }
                },
                stack: 'confidence-band',
                symbol: 'none'
            }, {
                name: 'U',
                type: 'line',
                data: data.map(function (item) {
                    return item.u - item.l;
                }),
                lineStyle: {
                    normal: {
                        opacity: 0
                    }
                },
                areaStyle: {
                    normal: {
                        color: '#ccc'
                    }
                },
                stack: 'confidence-band',
                symbol: 'none'
            }, {
                type: 'line',
                data: data.map(function (item) {
                    return item.value + base;
                }),
                hoverAnimation: false,
                symbolSize: 6,
                itemStyle: {
                    normal: {
                        color: '#c23531'
                    }
                },
                showSymbol: false
            }]
        });
    });
</script>
</html>
