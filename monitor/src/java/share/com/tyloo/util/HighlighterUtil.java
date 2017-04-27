package com.tyloo.util;
//package com.renhenet.util;
//
//import java.io.StringReader;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.analysis.cjk.CJKAnalyzer;
//import org.apache.lucene.queryParser.QueryParser;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.highlight.Highlighter;
//import org.apache.lucene.search.highlight.NullFragmenter;
//import org.apache.lucene.search.highlight.QueryScorer;
//import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
//
//public class HighlighterUtil {
//	private static Analyzer analyzer = new CJKAnalyzer();
//
//	public static String hignlight(String value, String keyWords) {
//		String str = null;
//
//		if (!StringUtils.isEmpty(value) && !StringUtils.isEmpty(keyWords)) {
//			try {
//				QueryParser queryParse = new QueryParser("content", analyzer);
//				queryParse.setDefaultOperator(QueryParser.AND_OPERATOR);
//
//				Query query = queryParse.parse(keyWords);
//				// 对要高亮显示的字段格式化，这里只是加红色显示和加粗
//				SimpleHTMLFormatter sHtmlF = new SimpleHTMLFormatter(
//						"<font class=saffron>", "</font>");
//
//				Highlighter highlighter = new Highlighter(sHtmlF,
//						new QueryScorer(query));
//				highlighter.setTextFragmenter(new NullFragmenter());
//
//				if (value != null) {
//					TokenStream tokenStream = analyzer.tokenStream("content",
//							new StringReader(value));
//
//					str = highlighter.getBestFragment(tokenStream, value);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if (StringUtils.isEmpty(str)) {
//			str = value;
//		}
//		return str;
//	}
//
//	public static void main(String[] args) {
//		String text = "《越狱3》播煞中国“狱友”  变形金刚巨型 惊现北京 《龙珠Z》绝招威力排行 《变形金 迅雷宽频合作发行 《越狱动画版》";
//
//		System.err.println(hignlight(text, "龙珠 变形金刚"));
//
//	}
//}
