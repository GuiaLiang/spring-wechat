package com.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.service.WechatService;

@Service
public class WechatServiceImpl implements WechatService {

	@Override
	public Map<String, String> getXMLParse(InputStream in) {
		Map<String, String> res = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			List<Element> elems = root.elements();
			
			for(Element elem : elems) {
				res.put(elem.getName(), elem.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return res;
	}

}
