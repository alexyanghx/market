<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
<script type="text/javascript" >

	var path = '<%=request.getContextPath()%>'
	wx.config({
	    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: '${jsapiSignature.appid}', // 必填，公众号的唯一标识
	    timestamp:'${jsapiSignature.timestamp}' , // 必填，生成签名的时间戳
	    nonceStr: '${jsapiSignature.noncestr}', // 必填，生成签名的随机串
	    signature: '${jsapiSignature.signature}',// 必填，签名，见附录1
	    jsApiList: [ 'onMenuShareTimeline',
	                'onMenuShareAppMessage',
	                 'onMenuShareQQ',
	                 'onMenuShareWeibo',
	                 'onMenuShareQZone' ] // 必填，需要使用的JS接口列表，所有JS接口列表见
	});
	
	// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	wx.ready(function(){
		wx.checkJsApi({
		    jsApiList: [ 'onMenuShareTimeline',
			                'onMenuShareAppMessage',
			                 'onMenuShareQQ',
			                 'onMenuShareWeibo',
			                 'onMenuShareQZone' ], 
		    success: function(res) {
		        // 以键值对的形式返回，可用的api值true，不可用为false
		        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
		    }
		});
		
		var activeUrl = 'http://123.57.174.156:8080/market/active/toSayGreet';
		
		//分享给朋友
		wx.onMenuShareAppMessage({
		    title: '一粒种子的梦想', // 分享标题
		    desc: '中秋不回家，爱一直都在', // 分享描述
		    link: activeUrl, // 分享链接
		    imgUrl: '', // 分享图标
		    type: 'link', // 分享类型,music、video或link，不填默认为link
		    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		    success: function () { 
		        // 用户确认分享后执行的回调函数
		    	 alert("分享成功");
		        window.location.href=path+'';
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    	alert("取消分享成功");
		    }
		});
		//分享到朋友圈
		wx.onMenuShareTimeline({
		    title: '一粒种子的梦想', // 分享标题
		    link: activeUrl, // 分享链接
		    imgUrl: '', // 分享图标
		    success: function () {
		        // 用户确认分享后执行的回调函数
		        alert("分享成功");
		    },
		    cancel: function () {
		        // 用户取消分享后执行的回调函数
		    	 alert("取消分享成功");
		    }
		});
		//分享到qq空间
		wx.onMenuShareQZone({
		    title: '', // 分享标题
		    desc: '', // 分享描述
		    link: '', // 分享链接
		    imgUrl: '', // 分享图标
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
		//分享到腾讯微博
		wx.onMenuShareWeibo({
		    title: '', // 分享标题
		    desc: '', // 分享描述
		    link: '', // 分享链接
		    imgUrl: '', // 分享图标
		    success: function () { 
		       // 用户确认分享后执行的回调函数
		    },
		    cancel: function () { 
		        // 用户取消分享后执行的回调函数
		    }
		});
		
		$.post()
		
	});
	
	wx.error(function(res){
		alert(res.toJSONString());
	    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
		alert(2222);
	    alert(res);
	});
	
	
	alert(location.href.split('#')[0]);
	
	alert(location.href.split('#')[0]);
	
</script>