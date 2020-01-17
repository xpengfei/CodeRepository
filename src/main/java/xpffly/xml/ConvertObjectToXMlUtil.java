package xpffly.xml;

import java.util.Map;

/**
 * @author szfh-xingpf
 * @create-time 2019年4月12日 上午11:51:05
 * @description： 将Object对象转化为XML报文
 */
public class ConvertObjectToXMlUtil {
	
	//适用于理财模块
	public static String convertObjetc2XMl(Map<String,Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<MAPS>"
				+ "<PUBLIC>");
		sb.append("<TRXCODE>"+map.get("TRXCODE")+"</TRXCODE>");
		sb.append("<APP_CODE>10056</APP_CODE>");
		sb.append("<TRX_ORIGIN>01</TRX_ORIGIN>");
		sb.append("</PUBLIC>");
		sb.append("<PRIVATE>");
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			sb.append("<"+entry.getKey()+">")
				.append(entry.getValue())
				.append("</"+entry.getKey()+">");
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		sb.append("</PRIVATE>"
				+ "</MAPS>");
		return sb.toString();
	}
	
	//适用于理财定投模块
//	public static String convertObjetc2XMlDT(Map<String,Object> map) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
//		sb.append("<FIMS>"
//				+ "<PUBLIC>");
//		sb.append("<TRXCODE>"+map.get("TRXCODE")+"</TRXCODE>");
//		sb.append("<APP_CODE>10056</APP_CODE>");
//		sb.append("<TRX_ORIGIN>01</TRX_ORIGIN>");
//		sb.append("</PUBLIC>");
//		sb.append("<PRIVATE>");
//		for(Map.Entry<String, Object> entry : map.entrySet()) {
//			sb.append("<"+entry.getKey()+">")
//				.append(entry.getValue())
//				.append("</"+entry.getKey()+">");
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
//		sb.append("</PRIVATE>"
//				+ "</FIMS>");
//		return sb.toString();
//	}
}
