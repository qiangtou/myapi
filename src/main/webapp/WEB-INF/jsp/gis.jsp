<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
   <title>GIS</title>
   <meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
   <meta http-equiv="X-UA-Compatible" content="IE=7" />
   <style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0;
	padding: 0
}

#map_canvas {
	width: 100%;
	height: 93%;
}

#toolbar {
	position: relative;
	left: 0px;
	top: 3px;
	width: 100%;
	height: 30px;
	z-index: 10000;
	background-color: #000000;
}

td {
	padding: 1% 0px 1% 0px;
	margin: 0px;
}
</style>
  </head>
  <body oncontextmenu="return false">
   <iframe id="ifShowVideo" src="about:blank" style="width: 0px; height: 0px; display: none"></iframe>
   <div id="map_canvas"></div>
   <div id="toolbar">
    <table>
     <tr>
      <td>
       <input id="btn_jumpToTrack" type="button" value="线索轨迹">
      </td>
      <td>
       <input id="btn_confirm" type="button" value="确定" style="display: none" onclick="confirmAddObject();">
      </td>
      <td>
       <input id="btn_modify" type="button" value="调整位置" style="display: none" onclick="confirmModifyObject();">
      </td>
      <td>
       <input id="btn_modify_sure" type="button" value="确定" style="display: none" onclick="doModifyObject();">
      </td>
      <td>
       <input id="btn_modify_cancle" type="button" value="取消" style="display: none" onclick="cancleModifyObject();">
      </td>
      <td>
       <input id="camera_distribution" type="button" value="监控点分布图" onclick="window.location.href='Gis_camera_distribution.php'"">
      </td>
     </tr>
    </table>
   </div>

  <script type="text/javascript">
//定义常量
	var OPERATE_TYPE_SHOW = 0;
	var OPERATE_TYPE_ADD_OBJECT = 1;
	var OPERATE_TYPE_MOD_OBJECT = 2;
	
	var SHOW_TYPE_ALL = 0; //保留，暂用不到
	var SHOW_TYPE_ALL_CASE = 1;
	var SHOW_TYPE_ALL_CAMERA = 2; //保留，暂用不到
	var SHOW_TYPE_SINGLE_CASE = 3;
	var SHOW_TYPE_SINGLE_CAMERA = 4; //保留，暂用不到
	
	var OBJECT_TYPE_CASE = 1; 
	var OBJECT_TYPE_CAMERA = 2; 
	var OBJECT_TYPE_MODIFYING = 3;
	
	var OBJECT_ID_INVALID = 0;
	
//定义全局变量
	var vOperateType = OPERATE_TYPE_SHOW;
	var vObjectType = OBJECT_TYPE_CASE;
	var vObjectId = OBJECT_ID_INVALID;
	var vObjectDesc = null;
	
	var vIsObjectExistsOnMap = ${g.isObjectExistsOnMap};
	var vIsParentCaseExistsOnMap = ${g.isParentCaseExistsOnMap};
	var vClickMapPoint = null;
	var vOverlays = new Array();
	var vLastSelectCaseId = null;
	var vLastSelectCameraId = null;
	
	var vXPosition = null;
	var vYPosition = null;
	var zoomLevel = ${g.zoomLevel};
	var init_longitude = ${g.initLongitude};
	var init_latitude = ${g.initLatitude};
</script>

  <script type="text/javascript"><%--
<?php	
//将PHP的数据传递给JavaScript
	if($isObjectExistsOnMap) {
		echo "vIsObjectExistsOnMap = true;";
	} else {
		echo "vIsObjectExistsOnMap = false;";
	}
	if($isParentCaseExistsOnMap) {
		echo "vIsParentCaseExistsOnMap = true;";
	} else {
		echo "vIsParentCaseExistsOnMap = false;";
	}
	echo "vOperateType = ".$operateType.";";
	echo "vShowType = ".$showType.";";
	echo "vObjectType = ".$objectType.";";
	echo "vObjectId = ".$objectId.";";
	echo "vCaseId = ".$caseId.";";
	echo "vObjectDesc = '".$objectDesc."';";
	//echo "alert('2')";
	
	echo "vXPosition = ".$xPosition.";";
	echo "vYPosition = '".$yPosition."';";
?>--%>
 vOperateType=${g.operateType}
 vShowType=${g.showType}
 vObjectType=${g.objectType}
 vObjectId=${g.objectId}
 vCaseId=${g.caseId}
 vXPosition=${g.xPosition}
 vYPosition=${g.yPosition}
 vObjectDesc='${g.objectDesc}'
	vLastSelectCaseId = vCaseId;
	var vLastShowType = vShowType;
	var vLastSelectType = vObjectType;
	vLastSelectId = vCaseId;
</script>
  <script src="http://ditu.google.cn/maps?file=api&amp;v=2&amp;key=AIzaSyBLrYMkdU6M-7KMKE2MUF37YsfLuBDk6Lg&sensor=false" type="text/javascript"></script>
  <script type="text/javascript" src="/js/lib/jquery.min.js"></script>
  <script language="vbscript"> 
Function str2asc(strstr) 
str2asc = hex(asc(strstr)) 
End Function 
Function asc2str(ascasc) 
asc2str = chr(ascasc) 
End Function 
</script>
  <script type="text/javascript">
function UrlDecode(str){ 
var ret=""; 
for(var i=0;i<str.length;i++){ 
   var chr = str.charAt(i); 
    if(chr == "+"){ 
      ret+=" "; 
    }else if(chr=="%"){ 
     var asc = str.substring(i+1,i+3); 
     if(parseInt("0x"+asc)>0x7f){ 
      ret+=asc2str(parseInt("0x"+asc+str.substring(i+4,i+6))); 
      i+=5; 
     }else{ 
      ret+=asc2str(parseInt("0x"+asc)); 
      i+=2; 
     } 
    }else{ 
      ret+= chr; 
    } 
} 
return ret; 
} 
 
function UrlEncode(str)
{ 
  var ret=""; 
  var strSpecial="!\"#$%&'()*+,/:;<=>?[]^`{|}~%"; 
  for(var i=0;i<str.length;i++){ 
  var chr = str.charAt(i); 
  var c=str2asc(chr); 
  if(parseInt("0x"+c) > 0x7f){ 
    ret+="%"+c.slice(0,2)+"%"+c.slice(-2); 
  }else{ 
    if(chr==" ") 
      ret+="+"; 
    else if(strSpecial.indexOf(chr)!=-1) 
      ret+="%"+c.toString(16); 
    else 
      ret+=chr; 
  } 
 } 
   return ret; 
}

//初始化地图控件
	var vMap = new GMap2(document.getElementById("map_canvas"));
	vMap.disableDoubleClickZoom();
	vMap.enableScrollWheelZoom();
	vMap.addControl(new GLargeMapControl());
	vMap.setCenter(new GLatLng(init_longitude,init_latitude), zoomLevel);
    //启用鼠标滚轮功能支持，参数true代表使用鼠标指向点位置不变模式   
	function changeShowType() {
		if(vShowType == SHOW_TYPE_ALL_CASE) {
			vShowType = SHOW_TYPE_SINGLE_CASE;
		} else {
			vShowType = SHOW_TYPE_ALL_CASE;
		}
	}
	function show(showType, caseId, isSupportInfoWindow) {
		if(showType == SHOW_TYPE_ALL_CASE) {
			showAllCases(isSupportInfoWindow);
		} else {
			showSingleCase(caseId, isSupportInfoWindow);
		}
	}
	function updateShow(caseId, isSupportInfoWindow) {
		clearAllOverlays();
		show(vShowType, caseId, isSupportInfoWindow);
	}
    GEvent.addListener(vMap, "dblclick", 
		function() {
			//alert("dblclick");
			//alert("vLastSelectCaseId:" + vLastSelectCaseId);
			if(vLastSelectCaseId == null || vLastSelectCaseId == OBJECT_ID_INVALID) {
				return;
			}
			changeShowType();
			updateShow(vLastSelectCaseId, vIsSupportInfoWindow);
            //ifShowVideo.location.href = "vscaseid:"+vLastSelectCaseId;
		}
	);  
	
	//自定义图标
	var baseIcon= new GIcon(G_DEFAULT_ICON);
	//baseIcon.shadow= "http://www.google.cn/mapfiles/shadow50.png";
	baseIcon.iconSize= new GSize(20, 20);
	//baseIcon.shadowSize= new GSize(37, 34);
	baseIcon.iconAnchor= new GPoint(10, 10);
	baseIcon.infoWindowAnchor= new GPoint(10, 0);
	var vIconCase = new GIcon(baseIcon);
	vIconCase.image= "images/IconCase.png";
	var vIconCamera = new GIcon(baseIcon);
	vIconCamera.image= "images/IconCamera.png";
	var vIconModify = new GIcon(baseIcon);
	vMap.getPane(G_MAP_FLOAT_SHADOW_PANE).style.display = "none"; 
	vMap.getPane(G_MAP_MARKER_SHADOW_PANE).style.display = "none"; 	
	
	$(document).ready(function(){
		$("#btn_jumpToTrack").click(turnToTrack);
  	setTimeout("shieldingLink()","1");//屏蔽超链接
  	});
	
	//定义辅助函数
	function verified(ori) {
/* 		indexOfDot = ori.indexOf(".", 0);
		if(indexOfDot<0 && ori.length>3) {
			return ori;
		}
		rightLen = indexOfDot >= 0 ? ori.length - indexOfDot - 1 : 0;
		tempStr = ori;
		if(rightLen > 5) {
			tempStr = tempStr.substr(0, indexOfDot + 6);
		} else if(rightLen < 5) {
			for(var i=5-rightLen; i>0; i--) {
				tempStr = tempStr + "0";
			}
		}
		return tempStr.replace(".", ""); */
		return ori;
	}
	
	//定义标注函数
	/*
	显示案件和监控点逻辑。
	*/
	function clearAllOverlays() {
		//alert(vOverlays.length);
		//vMap.overlayManager.removeOverLays(vOverlays);
		vMap.clearOverlays();
		//vOverlays = new Array();
	}
	function showSingleCase(caseId, isSupportInfoWindow) {
	    $.getJSON(
	        "GisGetObject.php?CaseId="+caseId,
	        function(msg)
	      	{
	      		if(msg.ret == 1)
	      		{
	      			showObject2(msg.CaseInfo.longitude, msg.CaseInfo.latitude, OBJECT_TYPE_CASE, msg.CaseInfo.objectDesc, msg.CaseInfo.objectId, isSupportInfoWindow);
	      			$.each(msg.CameraInfoList, function()
	      				{
	      					showObject2(this.longitude, this.latitude, OBJECT_TYPE_CAMERA, this.objectDesc, this.objectId, isSupportInfoWindow);
	      				}
					);
				}
	      	}
	    );
	}
	function showAllCases(isSupportInfoWindow) {
	    $.getJSON(
	        "GisGetObject.php",
	        function(msg)
	      	{
				//alert("msg.ret == " + msg.ret);
	      		if(msg.ret == 1)
	      		{
	      			$.each(msg.CaseInfoList, function()
	      				{
	      					showObject2(this.longitude, this.latitude, OBJECT_TYPE_CASE, this.objectDesc, this.objectId, isSupportInfoWindow);
	      					//alert("sdd");
	      				}
					);
	      		}
	      	}
	    );
	}
	function showObject(mapPoint, objectType, objectDesc, objectId, isSupportInfoWindow) {
		var overlays = null;
		if(objectType == null || objectType == undefined) {
			return overlays;
		}
		overlays = new Array();
		// Set up our GMarkerOptions object
		var markerOptions = {icon:vIconCase};
		if(objectType != null && objectType != undefined) {
			switch(objectType) {
			case OBJECT_TYPE_CASE:
				markerOptions.icon = vIconCase;
				break;				
			case OBJECT_TYPE_CAMERA:
				markerOptions.icon = vIconCamera;
				break;
			case OBJECT_TYPE_MODIFYING:
				markerOptions.icon = vIconModify;
				break;					
			}
		}
		
  	    var marker = new GMarker(mapPoint, markerOptions);  //创建点标注

        vMap.addOverlay(marker);   //将点标注添加到地图中
           
        if(isSupportInfoWindow)
        {
	        GEvent.addListener(marker, "mouseover", 
	         	function()
	         	{     
	         		if(vOperateType != OPERATE_TYPE_MOD_OBJECT)
	         		{
	         		  document.getElementById('btn_modify').style.display='';   
	         		}   		
	         		$.getJSON
	         		(
	         			"GisShowObjectInfo.php?ObjectType="+objectType+"&ObjectId="+objectId,
	         			function(msg)
	         			{            				
	         				if(msg.ret == 1)
	         				{       
	         					if(msg.objectType == 1)
	         					{
									marker.openInfoWindowHtml("<div style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;wzy:expression(void(this.title=this.innerText))' oncontextmenu='return false' align='left'>"+msg.msg+"</div>");
									vLastSelectCaseId = objectId;
									vLastSelectType = objectType;
									vLastSelectId = objectId;
	         					} else if(msg.objectType == 2)
	         					{
	         						vLastSelectId = objectId;
	         						vLastSelectType = objectType;
									//marker.openInfoWindowHtml("<div align='left'>"+msg.msg+"</div>");
									var info = "<div style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;wzy:expression(void(this.title=this.innerText))' oncontextmenu='return false' align='left'><span>"+UrlDecode(msg.msg)+"</span><span>视频列表：</span></div><div oncontextmenu='return false' style='height:90px;overflow:auto'>";
									//alert(info);
									var videos = msg.video;
									var filenames = msg.filename;
									if(videos != null)
									{
									for(var i = 0; i < videos.length;i++)
									{
									  info = info +"<div style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;wzy:expression(void(this.title=this.innerText))' oncontextmenu='return false'><a href='javascript:void(0)' video='vsvideo:path="+videos[i]+"' onclick='doClicked(this)'"+ ">"+UrlDecode(filenames[i])+"</a></div>";
									}
								  }
								  else
								  	{
								  	  info = info + "暂无视频";	
								  	}
								  info = info + "</div>";
									marker.openInfoWindowHtml(info);
	         					}
	         				}
	         			}
	         		);
	      		}
	        );
	    }
		
		overlays.push(marker);
		//vOverlays = vOverlays.concat(overlays);
		return overlays;
	}
	function showObject2(longitude, latitude, objectType, objectDesc, objectId, isSupportInfoWindow) {
		return showObject(new GLatLng(verified(latitude), verified(longitude)), objectType, objectDesc, objectId, isSupportInfoWindow);
	}
	
	function doClicked(video){
		//alert(video.video);
  	ifShowVideo.location.href= video.video;
  }
	//alert("3");

//在地图上展示对象
	var vIsSupportInfoWindow = (vOperateType == OPERATE_TYPE_SHOW);
	updateShow(vCaseId, vIsSupportInfoWindow);

var vClickListener = null;  
var vLastOverlays = null;
function addClickEvent() {  
	if(vClickListener == null) {
		vClickListener = GEvent.addListener(vMap, "click", function(ovarlay, latlng) {
			//alert(latlng.lat() + ":" + latlng.lng());
			if(latlng==null)
			{
			  	alert("请选择地图的空白位置");
			  	return;
			}	
			if(vOperateType == OPERATE_TYPE_MOD_OBJECT)
			{
				 vObjectType = OBJECT_TYPE_MODIFYING;
			}
			drawNewObjectOnMapPoint(latlng,vObjectType);
		}); 
	}	
}  
function removeClickEvent() {  
	GEvent.removeListener(vClickListener);  
	vClickListener = null;  
	//document.getElementById("showResult").innerHTML ="";  
}  
function removeOverlays(overlays) {
	for(var i=0; i<overlays.length; i++) {
		var overlay = overlays[i];
		vMap.removeOverlay(overlay);
	}
}
function drawNewObjectOnMapPoint(mapPoint,_vObjectType) {
	if(vLastOverlays != null) {
		removeOverlays(vLastOverlays);
	}
	vClickMapPoint = mapPoint;
	vLastOverlays = showObject(mapPoint, _vObjectType, "", vObjectId, false);
}
function doAddObject() {
	_url = "GisAddObject.php?objectType="+vObjectType+
	                "&objectId="+vObjectId+
	                "&longitude="+vClickMapPoint.lng()+
	                "&latitude="+vClickMapPoint.lat();
	
	if(vObjectDesc != null)
	{
		_url += "&objectDesc="; 
		_url += vObjectDesc;
	}
	$.getJSON(
	  	_url,
	   function(msg){
			if(msg.ret == "success") {
				vLastOverlays = null;
				removeClickEvent();
				document.getElementById('btn_confirm').style.display='none'; 
				document.getElementById('btn_jumpToTrack').style.display=''; 
				document.getElementById('btn_modify').style.display=''; 
				document.getElementById('btn_modify_cancle').style.display='none';
				//alert("vLastSelectCaseId:" + vLastSelectCaseId);
				vIsSupportInfoWindow = true;
				updateShow(vLastSelectCaseId, true);
				alert("添加成功");
			} else {
				alert("添加失败");
			}
	   }
	);
}
function confirmAddObject()  
{  
	if((vObjectType != OBJECT_TYPE_CASE && vObjectType != OBJECT_TYPE_CAMERA) || vObjectId == OBJECT_ID_INVALID) {
		alert("参数错误");
		return;
	}
	if(vClickMapPoint == null) {
		alert("未指定位置");
		return;
	}
	doAddObject();
}  

function confirmModifyObject()
{
	//alert("vLastSelectCaseId:" + vLastSelectCaseId);  	
  //alert("vObjectType:" + vObjectType); 	
  isSupportInfoWindow = false;
  show(vShowType, vLastSelectCaseId, isSupportInfoWindow);
	vOperateType = OPERATE_TYPE_MOD_OBJECT;
	var objectType = OBJECT_TYPE_MODIFYING;
	if(vOperateType == OPERATE_TYPE_MOD_OBJECT)
	{
	  	document.getElementById('btn_modify').style.display='none';
	  	document.getElementById('btn_jumpToTrack').style.display='none';
	  	document.getElementById('btn_modify_sure').style.display='';
	  	document.getElementById('btn_modify_cancle').style.display='';
	}
	var screenPoint = getOriginScreenPoint();
		var mapPoint = vMap.fromDivPixelToLatLng(screenPoint);
		drawNewObjectOnMapPoint(mapPoint,objectType);
		addClickEvent();
  return;	
}

function doModifyObject()
{
  _url = "GisModObject.php?objectType="+vLastSelectType+
	                "&objectId="+vLastSelectId+
	                "&longitude="+vClickMapPoint.lng()+
	                "&latitude="+vClickMapPoint.lat();
	$.getJSON(
	  	_url,
	   function(msg){
			if(msg.ret == "success") {
				vLastOverlays = null;
				removeClickEvent();
				//alert("vLastSelectCaseId:" + vLastSelectCaseId);
				vIsSupportInfoWindow = true;
				updateShow(vLastSelectCaseId, true);
				document.getElementById('btn_modify').style.display='none';
	  	  document.getElementById('btn_jumpToTrack').style.display='';
	  	  document.getElementById('btn_modify_sure').style.display='none';
	  	  document.getElementById('btn_modify_cancle').style.display='none';
	  	  vOperateType = OPERATE_TYPE_SHOW;
				alert("修改成功");
			} else {
				alert("修改失败");
			}
	   }
	);
  return;
}

function cancleModifyObject()
{
  window.location.href="gis.php?&showType="+vShowType+"&objectId="+vLastSelectCaseId;
  return;
}

function getOriginScreenPoint() {
    ix = vXPosition - window.screenLeft;
    iy = vYPosition - window.screenTop;

    return new GPoint(ix,iy);
}
//添加对象到地图上
/*document.getElementById('btn_confirm').style.display='none'; 
document.getElementById('btn_modify_sure').style.display='none';
document.getElementById('btn_modify_cancle').style.display='none';
*/
if(vOperateType == OPERATE_TYPE_ADD_OBJECT) {
	if(vIsObjectExistsOnMap) {
	    document.getElementById('btn_confirm').style.display='none'; 
		vIsSupportInfoWindow = true;
		updateShow(vLastSelectCaseId, true);
		alert("地图上已存在此" + (vObjectType == OBJECT_TYPE_CASE ? "案件" : "监控点"));
	} else if(vObjectType == OBJECT_TYPE_CAMERA && !vIsParentCaseExistsOnMap) {
		alert("必须先添加监控点所属的案件到地图上");
		window.location.href = "Gis.php";
	} else {
		var screenPoint = getOriginScreenPoint();
		var mapPoint = vMap.fromDivPixelToLatLng(screenPoint);
		drawNewObjectOnMapPoint(mapPoint,vObjectType);
		addClickEvent();
		document.getElementById('btn_confirm').style.display=''; 
		document.getElementById('btn_modify_cancle').style.display=''; 
		document.getElementById('btn_jumpToTrack').style.display='none'; 
		document.getElementById('btn_modify').style.display='none'; 
	}
	//addDblclickEvent();	
}

function turnToTrack()
{
	if(vLastSelectCaseId == null || vLastSelectCaseId == OBJECT_ID_INVALID) 
	{
		alert("必须先选择一个案件");   
		return;
	}
  window.location.href="GisTrack_google.php?caseid="+vLastSelectCaseId;	
}

function shieldingLink()
{
	$("div.gmnoprint:eq(0)").remove();
  $("a").attr("href","javascript:void(0)");
	$("a").attr("target","_self");
}
</script>
  </body>
 </html>