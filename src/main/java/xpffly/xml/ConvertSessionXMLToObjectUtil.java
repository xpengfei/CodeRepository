package xpffly.xml;

/**
 * @author szfh-xingpf
 * @create-time 2019年4月8日 上午11:58:49
 * @description：工具类---将Xml数据 转化为Object对象
 * 缺省实体类，但可以据此类进行代码优化，每个方法不超过二十行代码
 */
public class ConvertSessionXMLToObjectUtil {

    /*
	public static SessionDataIC2F_NameBean convertXML2Object(String xml) {
		SessionDataIC2F_NameBean sessionDataIC2F = new SessionDataIC2F_NameBean();
		Document doc = null;
		try {
			xml = dealXML(xml);	//将xml中的头部信息去掉，如：version等
			doc = DocumentHelper.parseText(xml);
			Element rootElement = doc.getRootElement(); // 获取xml数据根节点ICBCData
			sessionDataIC2F = getSessionDataIC2F_NameBean(rootElement);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return sessionDataIC2F;
	}
	//将xml头部信息去掉
	public static String dealXML(String xml) {
		if(xml.lastIndexOf("?") != -1) {
			xml = xml.substring(xml.lastIndexOf("?")+2);
		}
		return xml;
	}
	//解析xml中ICBCData节点下子节点信息
	public static SessionDataIC2F_NameBean getSessionDataIC2F_NameBean(Element rootElement) {
		SessionDataIC2F_NameBean sessionDataIC2F = generateSessionDataIC2F(rootElement);
		// 拿到节点RegCardSet
		Iterator iterator = rootElement.elementIterator("RegCardSet");
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			List<RegCardResultBean> listRegCard = new ArrayList<>();
			// 拿到RegCardResult节点
			Iterator innerIt = element.elementIterator("RegCardResult");
			while (innerIt.hasNext()) {
				Element innnerElement = (Element) innerIt.next();
				listRegCard.add(getRegCardResultBean(innnerElement));
			}
			sessionDataIC2F.setRegCardResult(listRegCard);
		}
		return sessionDataIC2F;
	}

	public static SessionDataIC2F_NameBean generateSessionDataIC2F(Element rootElement) {
		SessionDataIC2F_NameBean sessionDataIC2F = new SessionDataIC2F_NameBean();
		sessionDataIC2F.setLogonCardNum(rootElement.elementTextTrim("logonCardNum"));
		sessionDataIC2F.setCNcustName(rootElement.elementTextTrim("CNcustName"));
		sessionDataIC2F.setENcustName(rootElement.elementTextTrim("ENcustName"));
		sessionDataIC2F.setOperationId(rootElement.elementTextTrim("operationId"));
		sessionDataIC2F.setEBankRegType(rootElement.elementTextTrim("EBankRegType"));
		sessionDataIC2F.setManagerCredType(rootElement.elementTextTrim("managerCredType"));
		sessionDataIC2F.setManagerCredNum(rootElement.elementTextTrim("managerCredNum"));
		sessionDataIC2F.setManagerCIS(rootElement.elementTextTrim("managerCIS"));
		sessionDataIC2F.setBrowserType(rootElement.elementTextTrim("BrowserType"));
		sessionDataIC2F.setUsertype(rootElement.elementTextTrim("Usertype"));
		sessionDataIC2F.setUserlevel(rootElement.elementTextTrim("Userlevel"));
		return sessionDataIC2F;
	}

	//解析RegCardSet节点信息
	public static RegCardResultBean getRegCardResultBean(Element innnerElement) {
		RegCardResultBean regCardResult = generateRegCardResultBean(innnerElement);
		Iterator lastIt = innnerElement.elementIterator("AccountSet");
		while (lastIt.hasNext()) {
			Element lastEle = (Element) lastIt.next();
			List<AccountResultBean> listAcc = new ArrayList<>();
			// 拿到AccountResult节点
			Iterator lastInnerIt = lastEle.elementIterator("AccountResult");
			while (lastInnerIt.hasNext()) {
				Element fInnerEle = (Element) lastInnerIt.next();
				listAcc.add(getAccountResultBean(fInnerEle));
			}
			regCardResult.setAccountSet(listAcc);
		}
		return regCardResult;
	}

	public static RegCardResultBean generateRegCardResultBean(Element innnerElement) {
		RegCardResultBean regCardResult = new RegCardResultBean();
		regCardResult.setCardNum(innnerElement.elementTextTrim("cardNum"));
		regCardResult.setAcctType(innnerElement.elementTextTrim("acctType"));
		regCardResult.setAreaCode(innnerElement.elementTextTrim("areaCode"));
		regCardResult.setNetCode(innnerElement.elementTextTrim("netCode"));
		regCardResult.setCardStat(innnerElement.elementTextTrim("cardStat"));
		regCardResult.setCardAlias(innnerElement.elementTextTrim("cardAlias"));
		regCardResult.setRegMode(innnerElement.elementTextTrim("regMode"));
		regCardResult.setAreaName(innnerElement.elementTextTrim("areaName"));
		regCardResult.setCredType(innnerElement.elementTextTrim("credType"));
		regCardResult.setCredNum(innnerElement.elementTextTrim("credNum"));
		regCardResult.setCardOwner(innnerElement.elementTextTrim("cardOwner"));
		return regCardResult;
	}

	//解析AccountSet节点信息
	public static AccountResultBean getAccountResultBean(Element fInnerEle) {
		AccountResultBean accountResult = new AccountResultBean();
		accountResult.setAcctCode(fInnerEle.elementTextTrim("acctCode"));
		accountResult.setAcctNum(fInnerEle.elementTextTrim("acctNum"));
		accountResult.setAcctType(fInnerEle.elementTextTrim("acctType"));
		accountResult.setAcctProp(fInnerEle.elementTextTrim("acctProp"));
		accountResult.setLinkCardSign(fInnerEle.elementTextTrim("linkCardSign"));
		accountResult.setAcctAlias(fInnerEle.elementTextTrim("acctAlias"));
		return accountResult;
	}
	*/
}
