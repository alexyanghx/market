//package com.kindp.market.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import me.chanjar.weixin.common.bean.WxJsapiSignature;
//import me.chanjar.weixin.common.exception.WxErrorException;
//import me.chanjar.weixin.common.util.RandomUtils;
//import me.chanjar.weixin.common.util.StringUtils;
//import me.chanjar.weixin.mp.api.WxMpService;
//import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
//import me.chanjar.weixin.mp.bean.result.WxMpUser;
//
//import org.apache.log4j.Logger;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.kindp.market.util.WexinUtil;
//
//public class WexinAuthFilter extends OncePerRequestFilter {
//	private final Logger log = Logger.getLogger(this.getClass());
//	protected WxMpService wxMpService;
//
//	private final String scope_sapi_base = "snsapi_base";
//	private final String scope_snsapi_userinfo = "snsapi_userinfo";
//
//	private final String oauthTokenKey = "oauthToken";
//	private final String jsapiSignatureKey = "jsapiSignature";
//	@Override
//	protected void initFilterBean() throws ServletException {
//		// TODO Auto-generated method stub
//		super.initFilterBean();
//
//		//wxMpService = WexinUtil.getInstance();
//	}
//
//	private WxMpOAuth2AccessToken getOAuthToken(String code) throws WxErrorException {
//		WxMpOAuth2AccessToken oauthToken = wxMpService.oauth2getAccessToken(code);
////		oauthToken = wxMpService.oauth2refreshAccessToken(oauthToken.getRefreshToken());
//		return oauthToken;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest req,
//			HttpServletResponse res, FilterChain fc) throws ServletException,
//			IOException {
//		// TODO Auto-generated method stub
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			session = request.getSession(true);
//		}
//
//		log.info(String.format("weixin oauth filter sessionId :[%s]",session.getId()));
//		
//		Object oauthTokenObj = session.getAttribute(oauthTokenKey);
//		WxMpOAuth2AccessToken oauthToken = null;
//		
//		try {
//			//验证用户是否已经授权
//			if (oauthTokenObj == null) {
//				String code = request.getParameter("code");
//				log.info(String.format("weixin oauth code: [%s]",code));
//				//验证是否调用过授权页面
//				if(StringUtils.isBlank(code)){
//					String url = wxMpService.oauth2buildAuthorizationUrl(scope_snsapi_userinfo, "STATE");
//					log.info(String.format("weixin oauth url: [%s]",url));
//					res.sendRedirect(url);
//					doFilter(request, res, fc);
//					log.info("weixin oauth after sendredirect");
//					return ;
//				}
//				
//				oauthToken = getOAuthToken(code);
//				session.setAttribute(oauthTokenKey, oauthToken);
//				log.info(String.format("wexin oauth session setOAuth:key---[%s],value---[%s]",oauthTokenKey,oauthToken));
//				
//			} else {
//				
//				oauthToken = (WxMpOAuth2AccessToken) oauthTokenObj;
//				log.info(String.format("wexin oauth session getOAuth:key---[%s],value---[%s]",oauthTokenKey,oauthToken));
//				//验证oauthToken是否有效
//				if (!wxMpService.oauth2validateAccessToken(oauthToken)) {
//					log.info(String.format("weixin oauth validate: [%s]",false));
//					String url = wxMpService.oauth2buildAuthorizationUrl(scope_snsapi_userinfo, "1234");
//					res.sendRedirect(url);
//					doFilter(request, res, fc);
//					return;
//				}
//				log.info(String.format("weixin oauth validate: [%s]",true));
//			}
//
//			WxMpUser userInfo = wxMpService.oauth2getUserInfo(oauthToken, null);
//			log.info(String.format("weixin oauth getUserInfo: [%s]",userInfo));
//			session.setAttribute("userInfo", userInfo);
//			
//		} catch (WxErrorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			log.error("invoke oauth2getAccessToken is fail");
//			request.getRequestDispatcher("/error.jsp").forward(request, res);
//			return;
//		}
//		
//		StringBuffer url = request.getRequestURL();
//		log.info("request url : " + url.toString());
//
//		String queryStr = request.getQueryString();
//		log.info("request params : " + queryStr);
//
//		if (StringUtils.isNotBlank(queryStr) && queryStr.contains("=")) {
//			url.append("?").append(queryStr.split("#")[0]);
//		}
//		String fullUrl = url.toString();// URLEncoder.encode(,"utf-8");
//		boolean validSuccess = false;
//		WxJsapiSignature jsapiSignature;
//		try {
//			jsapiSignature = wxMpService.createJsapiSignature(fullUrl);
//			session.setAttribute(jsapiSignatureKey, jsapiSignature);
//			validSuccess = true;
//		} catch (WxErrorException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		if (!validSuccess) {
//			log.info("validSuccess==false,dispather error.jsp");
//			request.getRequestDispatcher("/error.jsp").forward(request, res);
//			return;
//		}
//
//		
//
//		doFilter(request, res, fc);
//	}
//
//}
