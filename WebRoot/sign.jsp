<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/weui.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<script src="https://cdn.bootcss.com/handlebars.js/4.0.11/handlebars.min.js"></script>
		<style>
			.ui-loader{
				display:none;
			}
		</style>
	</head>
	<body>
	
		<div class="container">
			<div class="head">
				<div class="success-icon">
					<i class="weui-icon-success weui-icon_msg"></i>
				</div>
				<h3>已签到</h3>
			</div>
			
			<div class="caidai">
				<img src="img/caidai3.png" alt="" />
			</div>
			
			<div class="box">
				<div class="xian">
					
				</div>
				<div class="show">
					
					签到派豆 <span class="num">${userinfo.sign_in_integration}</span>
				</div>
				
				<div class="table-head">
					<div class="today">
						<span id="today-year">2017</span>年
						<span id="today-month">11</span>月
					</div>
					<div class="my-jinyan">
						我的派豆：<span class="num"></span>
					</div>
				</div>
				
				<table class="day"  border="0" cellspacing="0" cellpadding="0">
					
				</table>
			</div>
			
			<div class="signTop">
				<div class="signTop-head">
					<div>签到top10</div>
					<div>
						今日已签到<span id="signNum"></span>人,我的排名<span id="paiming"></span>
					</div>
				</div>
				<ul>
					<li class="ul-head">
						<div>用户</div>
						<div>排名</div>
					</li>
				
					<script id="example-template" type="text/x-handlebars-template">
							{{#each news}}

							<li class="ul-body">
								<div class="userInfo">
									<div class="userFace">
										<img src="{{headimgurl}}" alt="头像" title="头像" />
									</div>
									<div class="userName">
										{{nickname}}
									</div>
								</div>
								<div class="level">{{rownum}}</div>
							</li>							
							
							{{/each}}
					</script>
					<!--以下为重复部分-->
					<span id="main-list">	
						
						
						
						
					</span>
					<!--重复部分结束-->
				</ul>
			</div>
			
			<div class="panel">
				<div class="panel-head">
					签到规则
				</div>
				<div class="panel-body">
					<p>
						1.每天签到可领取3个派豆;
					</p>
					<p>
						2.每天签到前十名，可额外获取5个派豆;
					</p>
					
					<p>
						3.派豆可以兑换派普肽产品的优惠券以及其他各种礼品，还能用于参与各种兑换活动哦，请大家按时签到，及时领取哦！;
					</p>
					<p>
						声明：派豆非日常货币，最终解释权归盈泰正和生物科技有限公司所有!
					</p>
				</div>
			</div>
			
			<div class="modal">
				<span class="bg" style="display: none;"></span>
				<div class="modal-success" style="display: none;">
					<i class="weui-icon-success weui-icon_msg"></i>
					<p>签到成功！</p>
					<button class="queren">确认</button>
				</div>
				<div class="modal-error" style="display: none;">
					<i class="weui-icon-warn weui-icon_msg-primary"></i>
					<p>您已成功签到，明天再来吧！</p>
					<button class="queren">确认</button>
				</div>
				<div class="modal-no" style="display: none;">
					<i class="weui-icon-warn weui-icon_msg"></i>
					<p>出错了！</p>
					<button class="queren">返回</button>
				</div>
			</div>
			
			
		</div>
		

		
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/jquery-mobile/1.4.5/jquery.mobile.min.js"></script>   
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		
		
		
		<script type="text/javascript">
				
				//$.ajaxSettings.async = false;
				//var a = location.search.split('?');
				//var b = a[1].split('=');
				//var c = b[1].split('&');
				//if(b[1] == '1'){
				//	$('.bg').css('display','block');
				//	$('.modal-success').css('display','block');
				//}else if(b[1] == '2'){
				//	$('.bg').css('display','block');
				//	$('.modal-error').css('display','block');
				//}else if(b[1] == '0'){
				//	$('.bg').css('display','block');
				//	$('.modal-no').css('display','block');
				//}
				
				$('.queren').on("tap",function(evt){
							$('.bg').css('display','none');
							$('.modal-success').css('display','none');
							$('.modal-error').css('display','none');
							$('.modal-no').css('display','none');
						})
				//签到
				$.ajax({
					type:"GET",
					url:"signIn.do",
					success:function(data){
						console.log(data);
						
						if(data == 1){
							console.log("success")
							$('.bg').css('display','block');
							$('.modal-success').css('display','block');
						}else if(data == 2){
							console.log("error")
							$('.bg').css('display','block');
							$('.modal-error').css('display','block');
						}else if(data== 0){
							console.log("失败")
							$('.bg').css('display','block');
							$('.modal-no').css('display','block');
						}
						
						$('.queren').on("tap",function(evt){
							$('.bg').css('display','none');
							$('.modal-success').css('display','none');
							$('.modal-error').css('display','none');
							$('.modal-no').css('display','none');
						})	
						//获取vip信息
						$.ajax({
							type:"GET",
							url:"selectVip.do",
							success:function(data){
								console.log(data);
								var data = JSON.parse(data);
								
								$('.num').text(data.sign_in_integration);
								$('#paiming').text(data.rownum);
								//获取模板数据
							
							},
							error:function(){
								alert('网络错误')
							}
						});
						//签到记录
						$.ajax({
							type:"GET",
							url:"signList.do",
							success:function(data){
								var data = JSON.parse(data);
								for(var i = 0;i<data.length;i++){
									for(var j = 0;j<$('.data').length;j++){
										if($('.data:eq('+j+')').text() == data[i].s_date){
											$('.data:eq('+j+')').css({'color':'#fff','background':'#519c4a'});
											$('.data:eq('+j+')').append('<br><i class="weui-icon-success-no-circle" style="margin-top:-6px;color: #fff;"></i>')
											console.log($('.data:eq('+j+')').text())
										}	
									}
								}
							},
							error:function(){
								alert('网络错误')
							}
						});
						// 签到排名列表
						$.ajax({
							type:"GET",
							url:"orderLi.do",
							success:function(data){
								//alert(data)
								//获取模板数据
								
								var data1 = JSON.parse(data);
								var theTemplateScript = $('#example-template').html();
								
								//Handlebars.compile编译模板
								var theTemplate = Handlebars.compile(theTemplateScript);
								
								//定义数据
								var context = {
									news:data1,
								};
								
								//把数据传送到模板
								var theCompiledHtml = theTemplate(context);

								
								//更新到模板
								$("#main-list").append(theCompiledHtml);
								
							},
							error:function(){
								alert('网络错误')
							}
						});
						//当日签到人数
						$.ajax({
							type:"GET",
							url:"signCount.do",
							success:function(data){
								console.log(data);
								var data1 = JSON.parse(data);
								$('#signNum').text(data1.count);			
							},
							error:function(){
								alert('网络错误')
							}
						});		
					},
					error:function(){
						alert('网络错误')
					}
				});
				
				
				//$.ajaxSettings.async = true;
		</script>
	</body>
</html>
