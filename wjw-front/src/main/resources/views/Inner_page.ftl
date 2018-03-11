<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="Keywords" content="">
		<meta name="Description" content="">
		<meta name="format-detection" content="telephone=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,minimum-scale=1.0">
		<link rel="stylesheet" href="${basePath}/css/reset.css">
		<link rel="stylesheet" href="${basePath}/css/index.css">
		<title>${modelName}</title>
	</head>
	<body>
		<div id="wrapper" class="inner_style">
			<!--<h2 class="int_title clearfix"><span class="int_pic"><img src="${basePath}/images/jifen/left.png"/></span>${modelName}</h2>-->
			<div class="int_title"><span class="int_pic"><a href="index.html"><img src="${basePath}/images/jifen/left.png"/></a></span>${modelName}</div>
							<div class="secskill-content inner_pages topline">
								<ul class="swiper-wrapper inner_nav">
									<li class="swiper-slide inner_con inner_con_style">
										电子数码
										<span class="inner_border_con" style="display: block;"></span>
									</li>
									<li class="swiper-slide inner_con">
										生活家电
										<span class="inner_border_con"></span>
									</li>
									<li class="swiper-slide inner_con">
										美容护肤
										<span class="inner_border_con"></span>
									</li>
									<li class="swiper-slide inner_con">
										居家必备
										<span class="inner_border_con"></span>
									</li>
								</ul>
							</div>
				<main>
					<div class="best_Sellers best_top clearfix">
						<ul style="display: block;" class="clearfix best_content">
							<#list list as index>  
						         <a href="Details_zoom.html">
								<li class="border_right fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
							<a href="Details_zoom.html">
								<li class="fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index+1}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
						    </#list> 
						</ul>
						<ul class="clearfix best_content">
							<#list list as index>  
						         <a href="Details_zoom.html">
								<li class="border_right fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
							<a href="Details_zoom.html">
								<li class="fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index+1}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
						    </#list> 
						</ul>
						<ul class="clearfix best_content">
							<#list list as index>  
						         <a href="Details_zoom.html">
								<li class="border_right fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
							<a href="Details_zoom.html">
								<li class="fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index+1}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
						    </#list> 
						</ul>
						<ul class="clearfix best_content">
							<#list list as index>  
						         <a href="Details_zoom.html">
								<li class="border_right fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
							<a href="Details_zoom.html">
								<li class="fl">
									<img src="${basePath}/images/jifen/sp2.png" />
									<span>迷你智能电饭煲${index+1}</span>
									<span class="int_color">86.0积分</span>
								</li>
							</a>
						    </#list> 
						</ul>
						
						
					</div>
					<p class="notice">没有更多商品了！</p>
			</main>
		<div id="back_top">
			<a href="#"><img src="${basePath}/images/xqq/the_top.png" /></a>
		</div>
		<script type="text/javascript" src="${basePath}/js/rem.js" ></script>
		<script type="text/javascript" src="${basePath}/js/swiper.min.js" ></script>
		<script type="text/javascript" src="${basePath}/js/index.js" ></script>
		<script type="text/javascript" src="${basePath}/js/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="${basePath}/js/inner.js" ></script>
		<script type="text/javascript" src="${basePath}/js/pay_success.js" ></script>
	</body>
</html>
