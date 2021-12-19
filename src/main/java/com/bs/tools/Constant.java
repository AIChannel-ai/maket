package com.bs.tools;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * 字典
 * 
 * @author Administrator
 *
 */
public class Constant {

	public static String SYSTEMNAME = "校园网上购物商城";

	/**
	 * 字典数据
	 * 
	 * @return
	 */
	public static Map<String, List<Dictionary>> getDictionary(HttpServletRequest request) {
		Map<String, List<Dictionary>> map = new HashMap<String, List<Dictionary>>();
		map.put("category", getCategorys());
		map.put("roles", getRoles());
		map.put("property", getProperty(request));
		return map;
	}

	/**
	 * 分类
	 * 
	 * @return
	 */
	private static List<Dictionary> getCategorys() {
		List<Dictionary> list = new ArrayList<Dictionary>();
		list.add(new Dictionary("Java", "Java"));
		list.add(new Dictionary("Net", "Net"));
		list.add(new Dictionary("Android", "Android"));
		list.add(new Dictionary("Php", "Php"));
		list.add(new Dictionary("Vb", "Vb"));
		return list;
	}

	/**
	 * 角色
	 * 
	 * @return
	 */
	private static List<Dictionary> getRoles() {
		List<Dictionary> list = new ArrayList<Dictionary>();
		list.add(new Dictionary("管理员", "管理员", false)); // 前台是否显示
		list.add(new Dictionary("普通用户", "普通用户", true));
		return list;
	}

	public static Map<String, String> getOrderStatus() {
		Map<String, String> map = new HashMap<>();
		map.put(StringEnumType.NO_SEND.getValue(), StringEnumType.NO_SEND.getValue());
		map.put(StringEnumType.SENDING.getValue(), StringEnumType.SENDING.getValue());
		map.put(StringEnumType.SEND_DONE.getValue(), StringEnumType.SEND_DONE.getValue());
		return map;
	}

	private static List<Dictionary> getProperty(HttpServletRequest request) {
		Map<String, List<Dictionary>> map = readConfig(request);
		List<Dictionary> list = new ArrayList<>();
		for (Map.Entry<String, List<Dictionary>> entry : map.entrySet()) {
			for (Dictionary dictionary : entry.getValue()) {
				dictionary.setTable(entry.getKey());
			}
			List<Dictionary> temp = entry.getValue();
			Collections.sort(temp);
			list.addAll(temp);
		}
		return list;
	}

	public static Map<String, List<Dictionary>> readConfig(HttpServletRequest request) {
		Map<String, List<Dictionary>> map = new HashMap<>();
		String xmlPath = request.getSession().getServletContext().getRealPath("/resources/fieldconfig.xml");
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(xmlPath));
			Element root = document.getRootElement();
			Iterator it = root.elementIterator();
			while (it.hasNext()) {
				Element table = (Element) it.next();
				List<Attribute> tableAttrs = table.attributes();
				String tableName = "";
				for (Attribute attr : tableAttrs) {
					tableName = attr.getValue();
					map.put(tableName, new ArrayList<Dictionary>());
				}
				// 解析子节点的信息
				Iterator itt = table.elementIterator();
				while (itt.hasNext()) {
					Dictionary dictionary = new Dictionary();
					Element child = (Element) itt.next();
					dictionary.setStyle(child.getStringValue());
					List<Attribute> colAttrs = child.attributes();
					for (Attribute col : colAttrs) {
						String name = col.getName();
						switch (name) {
						case "input":
							dictionary.setInput(col.getValue());
							break;
						case "show":
							dictionary.setShow(Boolean.valueOf(col.getValue()));
							break;
						case "listshow":
							dictionary.setListshow(Boolean.valueOf(col.getValue()));
							break;
						case "key":
							dictionary.setKey(col.getValue());
							break;
						case "value":
							dictionary.setValue(col.getValue());
							break;
						case "source":
							dictionary.setSource(col.getValue());
							break;
						case "def":
							dictionary.setDef(col.getValue());
							break;
						case "order":
							dictionary.setOrder(Integer.valueOf(col.getValue()));
							break;
						case "type":
							dictionary.setType(col.getValue());
							break;
						case "required":
							dictionary.setRequired(col.getValue());
							break;
						case "readonly":
							dictionary.setReadonly(col.getValue());
							break;
						}
					}
					map.get(tableName).add(dictionary);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return map;
		}
	}
}
