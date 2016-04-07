package com.kindp.market.service.impl;

import java.io.InputStream;

import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;

import com.thoughtworks.xstream.XStream;

public class BaseService {
	private WxMpConfigStorage configStorage;
	protected WxMpService wxMpService;
	
	public BaseService(){
		init();
	}
	
	protected synchronized void init(){
		if(configStorage==null){
			
		}
		
	}
	
	protected void initConfigStorage(){
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("wx-config.xml");
		
		XStream xstream = XStreamInitializer.getInstance();
	    xstream.processAnnotations(WxMpInMemoryConfigStorage.class);
	    configStorage = (WxMpInMemoryConfigStorage) xstream.fromXML(in);
	}
	
	public WxMpConfigStorage getConfigStorage(){
		return configStorage;
	}
}
