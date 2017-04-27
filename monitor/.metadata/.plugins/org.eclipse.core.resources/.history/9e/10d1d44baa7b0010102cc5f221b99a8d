package com.renhenet.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

@SuppressWarnings("unchecked")
public class XMLParser {

	public static Document parseXML(String filename) throws XMLParseException {
		File f = new File(filename);
		return parseXML(f);
	}

	public static Document parseStrXML(String xmlstr) throws JDOMException,
			IOException {
		xmlstr = xmlstr.replace("\n", "");
		xmlstr = xmlstr.replace("\t", "");
		xmlstr = xmlstr.replace("\r", "");
		SAXBuilder b = new SAXBuilder();
		return b.build(new StringReader(xmlstr));
	}

	public static Document parseXML(File file) throws XMLParseException {
		try {
			SAXBuilder b = new SAXBuilder();

			return b.build(file);

		} catch (Exception e) {
			e.printStackTrace();
			throw new XMLParseException(e);
		}
	}

	/**
	 * 根据路径找到节点
	 * 
	 * @param Document
	 *            document
	 * @param String
	 * 
	 * @return Element element
	 */
	public static Element getElement(Document doc, String path) {
		if (doc == null)
			return null;
		Element e = doc.getRootElement();
		if (path != null) {
			StringTokenizer st = new StringTokenizer(path, "/", false);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				e = e.getChild(token);
				if (e == null)
					return null;
			}
		}
		return e;
	}

	/**
	 * 根据路径返回节点的所有内容
	 * 
	 * @param Document
	 *            document
	 * @param String
	 * 
	 * @return Hashtable
	 */
	public static Hashtable getRecord(Document doc, String path) {
		if (doc == null) {
			return null;
		}

		Element e = getElement(doc, path);
		if (e == null) {
			return null;
		}

		Hashtable<String, String> ha = new Hashtable<String, String>();
		ha.put("name", e.getName());
		List attrs = e.getAttributes();
		if (attrs == null) {
			return ha;
		}

		Iterator attrit = attrs.iterator();
		while (attrit.hasNext()) {
			Attribute attr = (Attribute) attrit.next();
			ha.put(attr.getName(), attr.getValue());
		}
		attrs = e.getContent();
		if (attrs == null) {
			return ha;
		}

		attrit = attrs.iterator();
		while (attrit.hasNext()) {
			Element attr = (Element) attrit.next();
			ha.put(attr.getName(), attr.getValue());
		}
		return ha;
	}

	/**
	 * 根据路径返回该路径下的所有节点的所有内容
	 * 
	 * @param Document
	 *            document
	 * @param String
	 * 
	 * @return Vector----the contain object is Hashtable
	 */
	public static Hashtable getRecords(Document doc, String path) {
		if (doc == null)
			return null;
		Element e = getElement(doc, path);
		if (e == null)
			return null;
		List es = e.getChildren();
		if (es == null)
			return getRecord(doc, path);

		Iterator it = es.iterator();

		Hashtable<String, String> ha = new Hashtable<String, String>();
		while (it.hasNext()) {

			Element child = (Element) it.next();
			String key1 = child.getName();
			if (ha.get(key1) == null) {
				ha.put(key1, child.getValue());
			}

			List attrs = child.getAttributes();
			if (attrs == null)
				break;
			Iterator attrit = attrs.iterator();
			while (attrit.hasNext()) {
				Attribute attr = (Attribute) attrit.next();
				String key = attr.getName();
				if (ha.get(key) == null) {
					ha.put(key, attr.getValue());
				}
			}

		}
		return ha;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList getListRecords(Document doc, String path,
			String listTitle) {
		if (doc == null)
			return null;
		Element e = getElement(doc, path);
		if (e == null)
			return null;
		ArrayList all = new ArrayList();
		List a = e.getChildren(listTitle);
		for (Iterator i = a.iterator(); i.hasNext();) {
			Element foo = (Element) i.next();
			Hashtable<String, String> ha = new Hashtable<String, String>();
			List childs = foo.getChildren();
			if (childs == null)
				break;
			Iterator childit = childs.iterator();
			while (childit.hasNext()) {
				Element child = (Element) childit.next();
				String key = child.getName();
				if (ha.get(key) == null) {
					ha.put(key, child.getValue());
				}
			}

			List attrs = foo.getAttributes();
			if (attrs == null)
				break;
			Iterator attrit = attrs.iterator();
			while (attrit.hasNext()) {
				Attribute attr = (Attribute) attrit.next();
				String key = attr.getName();
				if (ha.get(key) == null) {
					ha.put(key, attr.getValue());
				}
			}
			all.add(ha);
		}
		return all;
	}

	// just for test
	public static void main(String[] args) {
		// try {
		// String str=FileUtil.readFile("d:\\11.xml");
		// Document doc=null;
		// try {
		// doc = parseStrXML(str);
		// } catch (JDOMException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// //
		// Hashtable news = getRecord(doc,"/bbbb");
		// System.err.println(news.toString());
		// Enumeration newskeys = news.keys();
		//
		// while (newskeys.hasMoreElements()) {
		// Object key = newskeys.nextElement();
		// System.err.println("newskeys: " + key + " " + news.get(key));
		// }
		//
		// Vector v = getRecords(doc, "/news");
		//
		// for (int i = 0; i < v.size(); i++) {
		// Hashtable values = (Hashtable) v.get(i);
		// Enumeration keys = values.keys();
		//
		// while (keys.hasMoreElements()) {
		// Object key = keys.nextElement();
		// System.err.println("key: " + key + " " + values.get(key));
		// }
		// }
		// } catch (XMLParseException e) {
		// e.printStackTrace();
		// }
	}

}