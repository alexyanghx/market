//package com.kindp.market.util;
//
//import java.io.InputStream;
//
//import org.apache.log4j.Logger;
//
//import com.thoughtworks.xstream.XStream;
//
//import me.chanjar.weixin.common.util.xml.XStreamInitializer;
//import me.chanjar.weixin.mp.api.WxMpConfigStorage;
//import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
//import me.chanjar.weixin.mp.api.WxMpService;
//import me.chanjar.weixin.mp.api.WxMpServiceImpl;
//
//public class WexinUtil {
//	private static final Logger log = Logger.getLogger(WexinUtil.class);
//	
//	static class WxMpServiceInstance{
//		
//		static{
//			init();
//		}
//		
//		private static WxMpService wxMpService;
//		private static WxMpConfigStorage configStorage;
//		private static void init(){
//			configStorage = new WxMpInMemoryConfigStorage();
//			initConfigStorage();
//
//			wxMpService = new WxMpServiceImpl();
//			wxMpService.setWxMpConfigStorage(configStorage);
//			log.info("wxMpService init success!");
//		}
//		
//		private static void initConfigStorage() {
//			InputStream in = WexinUtil.class.getClassLoader().getResourceAsStream("wx-config.xml");
//
//			XStream xstream = XStreamInitializer.getInstance();
////			xstream.processAnnotations(WxMpInMemoryConfigStorage.class);
//			xstream.alias("WxMpConfigStorage", WxMpInMemoryConfigStorage.class);
//			configStorage = (WxMpConfigStorage) xstream.fromXML(in);
//			log.info(String.format("initConfigStorage success :[%s]",configStorage.toString()));
//		}
//	} 
//	
//	public static WxMpService getInstance(){
//		return WxMpServiceInstance.wxMpService;
//	}
//	
//	public static WxMpConfigStorage getConfig(){
//		return WxMpServiceInstance.configStorage;
//	}
//}
