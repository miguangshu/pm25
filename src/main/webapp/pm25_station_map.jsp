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
<style type="text/css">
    body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
</style>
<script src="http://api.map.baidu.com/api?v=2.0&ak=uHkkRqHOFj3Z6Ajv3lLhCD8WjYjb6rFM"></script>
<div id="allmap"></div>
</body>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    map.addControl(new BMap.NavigationControl());
    var point = new BMap.Point(116.36115,39.952778);
    map.centerAndZoom(point, 12);
    var marker1 = new BMap.Marker(new BMap.Point(116.36115,39.952778));  // 创建标注
    var marker2 = new BMap.Marker(new BMap.Point(116.362372,39.938506));  // 创建标注
    var marker3 = new BMap.Marker(new BMap.Point(116.196745,39.913435));  // 创建标注
    var marker4 = new BMap.Marker(new BMap.Point(116.246293,40.294874));  // 创建标注
    var marker5 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker6 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker7 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker8 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker9 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker10 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker11 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注
    var marker12 = new BMap.Marker(new BMap.Point(116.374503,39.885816));  // 创建标注

    map.addOverlay(marker1);              // 将标注添加到地图中
    map.addOverlay(marker2);              // 将标注添加到地图中
    map.addOverlay(marker3);              // 将标注添加到地图中
    map.addOverlay(marker4);              // 将标注添加到地图中
    map.addOverlay(marker5);              // 将标注添加到地图中
    map.addOverlay(marker6);              // 将标注添加到地图中
    map.addOverlay(marker7);              // 将标注添加到地图中
    map.addOverlay(marker8);              // 将标注添加到地图中
    map.addOverlay(marker9);              // 将标注添加到地图中
    map.addOverlay(marker10);              // 将标注添加到地图中
    map.addOverlay(marker11);              // 将标注添加到地图中
    map.addOverlay(marker12);              // 将标注添加到地图中

    //    var label = new BMap.Label("西直门北大街",{offset:new BMap.Size(20,-10)});
//    marker.setLabel(label);
</script>
</html>
