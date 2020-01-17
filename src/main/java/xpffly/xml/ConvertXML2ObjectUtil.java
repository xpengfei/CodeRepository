package xpffly.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author szfh-xingpf
 * @create-time 2019年4月15日 上午11:05:47
 * @description：将XML转化为Object的工具类
 */
public class ConvertXML2ObjectUtil {

    public static Map convertRespXMLToList(String respXML) {
        Map<String, Object> map = new HashMap<String, Object>();
        String xml = dealXML(respXML);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element elementOption = (Element) iterator.next();
                Iterator iteratorOption = elementOption.elementIterator();
                while (iteratorOption.hasNext()) {
                    Element element = (Element) iteratorOption.next();
                    map.put(element.getName(), element.getTextTrim());
                }
            }

        } catch (DocumentException e) {
            //添加日志打印
        }
        return map;
    }

    // 将xml头部信息去掉
    public static String dealXML(String xml) {
        if (xml.lastIndexOf("?") != -1) {
            xml = xml.substring(xml.lastIndexOf("?") + 2);
        }
        return xml;
    }
}
