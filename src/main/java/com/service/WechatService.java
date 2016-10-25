package com.service;

import java.io.InputStream;
import java.util.Map;

public interface WechatService {
	public Map<String, String> getXMLParse(InputStream in);
}
