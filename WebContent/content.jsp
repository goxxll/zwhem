<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/main.css" />
<script type="text/javascript" src="js/imagerollover.js"></script>
</head>

	<div id="adv">
		<SCRIPT language=javascript>
			var m_nPageInitTime = new Date();
			var MainTopRoll = new xwzRollingImageTrans("IMG_MAIN_TOP_ROLL_DETAIL", "IMGS_MAIN_TOP_ROLL_THUMBNAIL");
			MainTopRoll.addItem("http://sc.chinaz.com/","images/shower_01.jpg");
			MainTopRoll.addItem("http://sc.chinaz.com/","images/shower_02.jpg");
			MainTopRoll.addItem("http://sc.chinaz.com/","images/shower_03.jpg");
			MainTopRoll.addItem("http://sc.chinaz.com/","images/shower_04.jpg");
		</SCRIPT>
	  <TABLE cellSpacing=0 cellPadding=0 width=575 align=center>
		<TBODY>
		  <TR>
			<TD id=IDS_DIV_MAIN_TOP_ROLL_DETAIL width=500 height=235><IMG  class=clssMainRoll height=235   src="images/shower_01.jpg"   width=500 border=0 name=IMG_MAIN_TOP_ROLL_DETAIL></TD>
			<!--
			<TD width=283 bgcolor="#F4F4F4" style="DISPLAY: none">
			-->
			<TD width=283 bgcolor="#F4F4F4"><TABLE cellSpacing=0 cellPadding=0 align=center>
				<TBODY>
				  <TR>
					<TD align=right height=60><IMG style="DISPLAY: none"	height=5 src="" width=9 align=absMiddle border=0 name=IMGS_MAIN_TOP_ROLL_THUMBNAIL><IMG 
						style="CURSOR: pointer" onclick=MainTopRoll.alterImage(0) 	src="images/mini_01.jpg" border=0></TD>
				  </TR>
				  <TR>
					<TD align=right height=60><IMG style="DISPLAY: none" 	height=5 src="" width=9 align=absMiddle border=0 name=IMGS_MAIN_TOP_ROLL_THUMBNAIL><IMG 
						style="CURSOR: pointer" onclick=MainTopRoll.alterImage(1) src="images/mini_02.jpg" border=0></TD>
				  </TR>
				  <TR>
					<TD align=right height=60><IMG style="DISPLAY: none"  height=5 src="" width=9 align=absMiddle border=0 name=IMGS_MAIN_TOP_ROLL_THUMBNAIL><IMG 
						style="CURSOR: pointer" onclick=MainTopRoll.alterImage(2) src="images/mini_03.jpg" border=0></TD>
				  </TR>
				  <TR>
					<TD align=right height=60><IMG style="DISPLAY: none" height=5 src="" width=9 align=absMiddle border=0 name=IMGS_MAIN_TOP_ROLL_THUMBNAIL><IMG 
						style="CURSOR: pointer" onclick=MainTopRoll.alterImage(3) src="images/mini_04.jpg" border=0></TD>
				  </TR>
				</TBODY>
			</TABLE></TD>
		  </TR>
		</TBODY>
	  </TABLE>
    <SCRIPT language=JavaScript>
		MainTopRoll.Index =  parseInt('0');
		MainTopRoll.install();
    </SCRIPT>
	</div>
	<div id="advlist">
	<div>
		<h2 class="title01">最新活动</h2>
		<p><a href="#"><img src="product/images/smallpic/iphone4s_small.jpg" alt="iphone4s" width="75" height="50"></a></p>
		<h3><a href="#">iphone 4S白色版</a>， ￥4999.00</h3>
		<p> 2012苹果4S4代苹果,32G内存,800万像素 情人节特价优惠中……</p>
	</div>
	<div>
		<h2 class="title02">热卖产品</h2>
		<p><a href="product/canoninf.html"><img src="product/images/smallpic/canoneos5d_small.jpg" alt="iphone4s" width="75" height="50"></a></p>
		<h3><a href="product/canoninf.html">佳能（Canon） EOS 5D Mark II 单反套机 </a>￥20999.00</h3>
		<p>佳能（Canon） EOS 5D Mark II 单反套机（EF 24-105mm f/4L IS USM 镜头）,拥有约2110万有效像素、约3.9张/秒的高画质、高速连拍性能。</p>
	</div>
	<div>
		<h2 class="title03">新品上架</h2>
		<p><a href="product/ipad2inf.html"><img src="product/images/smallpic/ipad_small.jpg" alt="iphone4s" width="75" height="50"></a></p>
		<h3> <a href="product/ipad2inf.html">苹果wifi版IPAD2</a>  ￥3699.00</h3>
		<p> 苹果wifi版IPAD2（16G）二代（MC979CH）,薄了，轻了，快了 快来抢先体验吧！送苹果保护膜。为 FaceTime 和 HD 高清摄像而配备的双摄像头。Dual-core 双核 A5 处理器。同样的 10 小时电池使用时间1。全新更轻、更薄的设计。如今的 iPad ，更为出色，更加轻薄。</p>
	</div>
	</div>
		


</html>