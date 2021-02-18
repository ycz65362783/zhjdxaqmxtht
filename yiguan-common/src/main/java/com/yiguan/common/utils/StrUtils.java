package com.yiguan.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtils {

	public static final String EMPTY_STRING = "";

	private static final String PRE_FIX_UTF = "&#x";
	private static final String POS_FIX_UTF = ";";

	public static final String UNDERLINE = "_";

	public static final String[] NUMBER_ARR = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	public static final String[] NUMBER_UNIT_ARR = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static List<String> splitString(String str) {
		return splitString(str, ",");
	}

	public static List<String> splitString(String str, String splitChar) {
		if (StringUtils.isBlank(str)) {
			return Collections.emptyList();
		}

		if (StringUtils.isBlank(splitChar)) {
			splitChar = ",";
		}

		return Arrays.asList(str.split(","));

	}

	public static String mergeCustomerOrder(String baryHawb, String dn) {
			return baryHawb + "," + dn;
	}

	public static String toUpperCase(String str) {
		return null2empty(str).toUpperCase();
	}

	public static String toLowwerCase(String str) {
		return null2empty(str).toLowerCase();
	}

	public static String upperFirst(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}

	public static String lowwerFirst(String name) {
		char[] cs = name.toCharArray();
		cs[0] += 32;
		return String.valueOf(cs);
	}

	/**
	 * 字段名称转换方法,将passWord转成pass_word
	 * 
	 * @param filed
	 *            字段名称
	 * @return String
	 */
	public static String replaceFiled(String filed) {
		String regEx = "([A-Z])"; // 表示一个或多个
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(filed);
		while (m.find()) {
			filed = filed.replace(m.group(1), "_" + m.group(1).toLowerCase());
		}
		if (filed.startsWith("_")) {
			filed = filed.substring(1);
		}
		return filed;
	}

	/**
	 * 
	 * @Title: replaceFiledFirstLowwer @Description: te_tt to teTt @param @param
	 *         filed @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String replaceFiledFirstLowwer(String filed) {
		String[] f = filed.split("_");
		StringBuffer sb = new StringBuffer();
		if (null != f && f.length > 0) {
			for (int i = 0, len = f.length; i < len; i++) {
				if (i == 0) {
					sb.append(f[i].toLowerCase().substring(0, 1).trim());
				} else {
					sb.append(f[i].toUpperCase().substring(0, 1).trim());
				}

				sb.append(f[i].toLowerCase().substring(1).trim());

			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * @Title: replaceFiledFirstUpper @Description: te_tt to TeTt @param @param
	 *         filed @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String replaceFiledFirstUpper(String filed) {
		String[] f = filed.split("_");
		StringBuffer sb = new StringBuffer();
		if (null != f && f.length > 0) {
			for (int i = 0, len = f.length; i < len; i++) {
				sb.append(f[i].toUpperCase().substring(0, 1).trim()).append(f[i].toLowerCase().substring(1).trim());

			}
		}

		return sb.toString();
	}

	public static StringBuffer append(StringBuffer sb, String str) {
		if (null != str) {
			sb.append(str);
		}
		return sb;
	}

	public static String substr(String str, int length) {
		if (StringUtils.isEmpty(str)) {
			return "";
		} else {
			return str.substring(0, str.length() > length ? length : str.length());
		}

	}

	public static String substring(String str, int start, int length) {
		byte[] strTemp = new byte[length];
		System.arraycopy(str.getBytes(), start, strTemp, 0, length);
		return new String(strTemp);
	}

	/**
	 * 
	 * @param str
	 * @param startIndex
	 *            index 从1开始
	 * @param endIndex
	 * @return
	 */
	public static String substringse(String str, int startIndex, int endIndex) {
		byte[] strTemp = new byte[endIndex - startIndex + 1];
		System.arraycopy(str.getBytes(), startIndex - 1, strTemp, 0, endIndex - startIndex + 1);
		return new String(strTemp);
	}

	public static String substring(String str, int start) {
		byte[] strTemp = new byte[str.getBytes().length - start];
		System.arraycopy(str.getBytes(), start, strTemp, 0, str.getBytes().length - start);
		return new String(strTemp);
	}

	public static String substringAll(String str, int length) {
		if (str.getBytes().length > length) {
			byte[] strTemp = new byte[length];
			System.arraycopy(str.getBytes(), 0, strTemp, 0, length);
			return new String(strTemp);
		} else {
			return str;
		}

	}

	public static byte[] setStr(byte[] strByte, String str, int stratIndex, int endIndex) {
		int length = endIndex - stratIndex + 1;
		if (null == str) {
			str = "";
		}

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(str);
		if (str.getBytes().length < length) {
			int diff = length - str.getBytes().length;
			for (int i = 0; i < diff; i++) {
				stringBuffer.append(" ");
			}
		}
		System.arraycopy(stringBuffer.toString().getBytes(), 0, strByte, stratIndex - 1, length);
		return strByte;
	}

	/**
	 * 是否有中文字符
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasCn(String s) {
		if (s == null) {
			return false;
		}
		return countCn(s) > s.length();
	}

	/**
	 * 获得字符。符合中文习惯。
	 * 
	 * @param s
	 * @param len
	 * @return
	 */
	public static String getCn(String s, int len) {
		if (s == null) {
			return s;
		}
		int sl = s.length();
		if (sl <= len) {
			return s;
		}
		// 留出一个位置用于…
		len -= 1;
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		while (count < maxCount && i < sl) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
			i++;
		}
		if (count > maxCount) {
			i--;
		}
		return s.substring(0, i) + "…";
	}

	/**
	 * 计算GBK编码的字符串的字节数
	 * 
	 * @param s
	 * @return
	 */
	public static int countCn(String s) {
		if (s == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		return count;
	}

	// 将特殊字符号转换成空格
	public static String TransactSQLInjection(String str) {
		return str.replaceAll(".*([';]+|(--)+).*", " ");
	}

	/**
	 * 文本转html
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		StringBuilder bld = new StringBuilder();
		char c;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			switch (c) {
			case '&':
				bld.append("&amp;");
				break;
			case '<':
				bld.append("&lt;");
				break;
			case '>':
				bld.append("&gt;");
				break;
			case '"':
				bld.append("&quot;");
				break;
			case ' ':
				bld.append("&nbsp;");
				break;
			case '\n':
				bld.append("<br/>");
				break;
			default:
				bld.append(c);
				break;
			}
		}
		return bld.toString();
	}

	/**
	 * html转文本
	 * 
	 * @param htm
	 * @return
	 */
	public static String htm2txt(String htm) {
		if (htm == null) {
			return htm;
		}
		htm = htm.replace("&amp;", "&");
		htm = htm.replace("&lt;", "<");
		htm = htm.replace("&gt;", ">");
		htm = htm.replace("&quot;", "\"");
		htm = htm.replace("&nbsp;", " ");
		htm = htm.replace("<br/>", "\n");
		return htm;
	}

	public static String htm2blank(String htm) {
		if (htm == null) {
			return htm;
		}
		htm = htm.replace("&amp;", "");
		htm = htm.replace("&lt;", "");
		htm = htm.replace("&gt;", "");
		htm = htm.replace("&quot;", "");
		htm = htm.replace("&nbsp;", "");
		htm = htm.replace("<br/>", "");
		return htm;
	}

	public static int null2zero(Object o) {
		if (o == null) {
			return 0;
		}
		if (StringUtils.isBlank(null2empty(o))) {
			return 0;
		}
		return Integer.parseInt(o.toString());
	}

	public static float null2zeroFloat(Object o) {
		if (o == null) {
			return 0.0f;
		}
		if (StringUtils.isBlank(o.toString())) {
			return 0.0f;
		}
		return Float.parseFloat(o.toString());
	}

	public static double null2zeroDouble(Object o) {
		if (o == null || o == "") {
			return 0.00;
		}

		return Double.parseDouble(o.toString());
	}

	public static String null2empty(Object o) {
		return null == o ? "" : o.toString().trim();
	}

	public static boolean null2boolean(Object o) {
		return o == null ? false : (boolean) o;
	}

	/**
	 * 全角-->半角
	 * 
	 * @param qjStr
	 * @return
	 */
	public static String Q2B(String qjStr) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < qjStr.length(); i++) {
			try {
				Tstr = qjStr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;
				try {
					outStr = outStr + new String(b, "unicode");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else
				outStr = outStr + Tstr;
		}
		return outStr;
	}

	public static final char[] N62_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };
	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private static StringBuilder longToNBuf(long l, char[] chars) {
		int upgrade = chars.length;
		StringBuilder result = new StringBuilder();
		int last;
		while (l > 0) {
			last = (int) (l % upgrade);
			result.append(chars[last]);
			l /= upgrade;
		}
		return result;
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @return
	 */
	public static String longToN62(long l) {
		return longToNBuf(l, N62_CHARS).reverse().toString();
	}

	public static String longToN36(long l) {
		return longToNBuf(l, N36_CHARS).reverse().toString();
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @param length
	 *            如N62不足length长度，则补足0。
	 * @return
	 */
	public static String longToN62(long l, int length) {
		StringBuilder sb = longToNBuf(l, N62_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	public static String longToN36(long l, int length) {
		StringBuilder sb = longToNBuf(l, N36_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	/**
	 * N62转换成整数
	 * 
	 * @param n62
	 * @return
	 */
	public static long n62ToLong(String n62) {
		return nToLong(n62, N62_CHARS);
	}

	public static long n36ToLong(String n36) {
		return nToLong(n36, N36_CHARS);
	}

	private static long nToLong(String s, char[] chars) {
		char[] nc = s.toCharArray();
		long result = 0;
		long pow = 1;
		for (int i = nc.length - 1; i >= 0; i--, pow *= chars.length) {
			int n = findNIndex(nc[i], chars);
			result += n * pow;
		}
		return result;
	}

	private static int findNIndex(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		throw new RuntimeException("N62(N36)非法字符：" + c);
	}

	public static String formatByLength(int length, String str, String fromatStr) {

		if (null == str) {
			return str;
		}
		int strLength = str.length();

		if (length == strLength) {
			return str;
		}

		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < length - strLength; i++) {
			sb.insert(0, fromatStr);
		}
		return sb.toString();

	}

	/*
	 * 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/*
	 * 判断是否为Double
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");

		return pattern.matcher(str).matches();

		// Pattern pattern = Pattern.compile("^[-+]?[.d]*$");
		// return pattern.matcher(str).matches();
	}

	/**
	 * 判断空行
	 * 
	 * @param map
	 * @return boolean 返回布尔类型值
	 */
	public static boolean isNullMap(Map<String, Object> map) {
		boolean flag = true;

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() != null && !entry.getValue().equals(null) && !entry.getValue().equals("")) {
				flag = false;
			}
		}

		return flag;
	}

	/**
	 * 对一个字符串末尾添加字符，如邮件地址,多个需要在末尾添加逗号<br>
	 * caipeikun@kerryeas.com,<br>
	 * 
	 * @param str
	 *            需要添加的字符串
	 * @param charStr
	 *            末尾要添加的字符
	 * @return 返回新的字符串
	 */
	public static String endApendChar(String str, String charStr) {
		if ("".equals(str) || str.endsWith(charStr)) {
			return str;
		} else {
			return str + charStr;
		}
	}

	public static String endApendChar(String str, char charStr) {
		return endApendChar(str, String.valueOf(charStr));
	}

	/*
	 * 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */

	public static void main(String[] args) {
		System.out.println(replaceFiledFirstLowwer("tt_aAba"));
	}

	/**
	 * 判断字符串类型
	 * 
	 * @param str
	 *            字符串类型
	 * @param length
	 *            字符串长度
	 * @return boolean 返回布尔类型值
	 */
	public static boolean checkLength(String str, int length) {
		if (null == str || StringUtils.isEmpty(str)) {
			return true;
		}
		return str.getBytes().length <= length;
		/*
		 * 
		 * Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]"); Matcher m =
		 * p.matcher(value); int i=value.length(); while (m.find()){ i++; }
		 */
	}

	/**
	 * Translate charset encoding to unicode
	 *
	 * @param sTemp
	 *            charset encoding is gb2312
	 * @return charset encoding is unicode
	 */
	public static String XmlFormalize(String sTemp) {
		StringBuffer sb = new StringBuffer();

		if (sTemp == null || sTemp.equals("")) {
			return "";
		}
		String s = str2GB2312(sTemp);
		for (int i = 0; i < s.length(); i++) {
			char cChar = s.charAt(i);
			if (isGB2312(cChar)) {
				sb.append(PRE_FIX_UTF);
				sb.append(Integer.toHexString(cChar));
				sb.append(POS_FIX_UTF);
			} else {
				switch (cChar) {
				case 32:
					sb.append("&#32;");
					break;
				case 34:
					sb.append("&quot;");
					break;
				case 38:
					sb.append("&amp;");
					break;
				case 60:
					sb.append("&lt;");
					break;
				case 62:
					sb.append("&gt;");
					break;
				default:
					sb.append(cChar);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将字符串编码格式转成GB2312
	 *
	 * @param str
	 * @return
	 */
	public static String str2GB2312(String str) {
		try {
			String strEncode = getEncoding(str);
			String temp = new String(str.getBytes(strEncode), "GB2312");
			return temp;
		} catch (java.io.IOException ex) {

			return null;
		}
	}

	/**
	 * 将字符串编码格式转成UTF-8
	 *
	 * @param str
	 * @return
	 */
	public static String str2UTF8(String str) {
		try {
			String strEncode = getEncoding(str);
			String temp = new String(str.getBytes(strEncode), "UTF-8");
			return temp;
		} catch (java.io.IOException ex) {

			return null;
		}
	}

	/**
	 * 将字符串编码格式转成GBK
	 *
	 * @param str
	 * @return
	 */
	public static String str2GBK(String str) {
		try {
			String strEncode = getEncoding(str);
			String temp = new String(str.getBytes(strEncode), "GBK");
			return temp;
		} catch (java.io.IOException ex) {

			return null;
		}
	}

	/**
	 * 判断输入字符是否为gb2312的编码格式
	 *
	 * @param c
	 *            输入字符
	 * @return 如果是gb2312返回真，否则返回假
	 */
	public static boolean isGB2312(char c) {
		Character ch = new Character(c);
		String sCh = ch.toString();
		try {
			byte[] bb = sCh.getBytes("gb2312");
			if (bb.length > 1) {
				return true;
			}
		} catch (UnsupportedEncodingException ex) {
			return false;
		}
		return false;
	}

	/**
	 * 判断字符串的编码
	 *
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}

	/**
	 * 进制转换
	 * 
	 * @param x
	 *            要转换的value
	 * @param c
	 *            内容
	 * @return
	 */
	private static String convert(int x, char[] c) {
		if (x <= 0) {
			return "";
		}
		if (null == c || c.length == 0) {
			return "";
		}
		int length = c.length;
		StringBuilder sb = new StringBuilder();
		while (x > 0) {
			int mod = x % length;
			if (mod == 0) {
				mod = length;
			}
			sb.insert(0, c[mod - 1]);
			x = (x) / length;
		}
		return sb.toString();
	}

	/**
	 * 将数字转成26进制如Excel那样的格式
	 * 
	 * @param x
	 * @return
	 */
	public static String intToExcel(int x) {
		char[] c = new char[26];
		for (int i = 0; i < 26; i++) {
			c[i] = (char) ('A' + i);
		}
		return convert(x, c);
	}

	public static String int2Excel(String x) {

		return intToExcel(StrUtils.null2zero(x));
	}

	/**
	 * 将数字转成26进制如Excel那样的格式
	 * 
	 * @param x
	 * @return
	 */
	public static String intTo36(int x) {
		char[] c = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'Z', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'U', 'W', 'X', 'Y', 'Z', '0' };
		return convert(x, c);
	}

	/**
	 * @author caixl
	 * @title 对字符串进行补位
	 * @param oldStr
	 *            要格式化的字符串
	 * @param replace
	 *            用什么字符补
	 * @author len 补位后的长度(字节数)
	 * @author type 补前或补后 'F'补前，'L'补后
	 * @return
	 */
	public static String formatStr(Object oldStr, String replace, int len, String type) {
		if (len < StrUtils.null2empty(oldStr).getBytes().length) {
			return new String(StrUtils.null2empty(oldStr).getBytes(), 0, len);
		}
		StringBuffer sb = new StringBuffer();

		if (type.equals("L")) {
			sb.append(StrUtils.null2empty(oldStr));
		}
		for (int i = 0; i < len - StrUtils.null2empty(oldStr).getBytes().length; i++) {
			sb.append(replace);
		}
		if (type.equals("F")) {
			sb.append(StrUtils.null2empty(oldStr));
		}
		return sb.toString();
	}

	/**
	 * 字符串按字节截取
	 * 
	 * @param str
	 *            原字符
	 * @param len
	 *            截取长度
	 * @return String
	 * @author eric
	 * @since 2010.07.05
	 */
	public static String splitString(String str, int len) {
		return splitString(str, len, "...");
	}

	/**
	 * 字符串按字节截取
	 * 
	 * @param str
	 *            原字符
	 * @param len
	 *            截取长度
	 * @param elide
	 *            省略符
	 * @return String
	 * @author Eric
	 * @since 2010.07.05
	 */
	public static String splitString(String str, int len, String elide) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		// int elideLen = (elide.trim().length() == 0) ? 0 :
		// elide.getBytes().length;
		int elideLen = 0;
		if (len >= strLen || len < 1) {
			return str;
		}
		if (len - elideLen > 0) {
			len = len - elideLen;
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;
		}
		return new String(strByte, 0, len) + elide.trim();
	}

	public static String subStr(String str, int num) {
		int max = num;
		try {
			max = trimGBK(str.getBytes("GBK"), num);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int sum = 0;
		if (str != null && str.length() > max) {
			StringBuilder sb = new StringBuilder(max);
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				// if ((c & 0xff00) != 0)
				// sum += 2;
				// else
				sum += 1;
				if (sum <= max)
					sb.append((char) c);
				else
					break;
			}
			return sb.append("...").toString();
		} else
			return str != null ? str : "";
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		if (buf.length < n)
			return buf.length;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}

		return num;
	}

	public static boolean isContainChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]"); // "[\u4e00-\u9fa5]"
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public static String trim(String str) {
		if (StringUtils.isNotBlank(str)) {
			str = str.replaceAll(" ", "");
			str = str.trim();
		}
		return str;
	}

	public static String convertUnicode2Gbk(String utfString) {
		StringBuilder sb = new StringBuilder();
		int i = -1;
		int pos = 0;

		while ((i = utfString.indexOf("\\u", pos)) != -1) {
			sb.append(utfString.substring(pos, i));
			if (i + 5 < utfString.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
			}
		}

		return sb.toString();
	}

	/**
	 * 大陆号码或香港号码均可
	 */
	public static boolean isPhone(String phoneNumber) {
		return isChinaPhone(phoneNumber) || isHKPhone(phoneNumber);
	}

	/**
	 * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 此方法中前三位格式有： 13+任意数 15+除4的任意数 18+除1和4的任意数
	 * 17+除9的任意数 147
	 */
	private static boolean isChinaPhone(String phoneNumber) {
		String reg = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

	/**
	 * 香港手机号码8位数，5|6|8|9开头+7位任意数
	 */
	private static boolean isHKPhone(String phoneNumber) {
		String reg = "^(5|6|8|9)\\d{7}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

	/**
	 * 区号+座机号码+分机号码
	 * 
	 * @param fixedPhone
	 * @return
	 */
	public static boolean isFixedPhone(String fixedPhone) {
		String reg = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(fixedPhone);
		return m.matches();
	}

	/**
	 * 匹配中国邮政编码
	 * 
	 * @param postCode
	 *            邮政编码
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isPostCode(String postCode) {
		String reg = "[1-9]\\d{5}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(postCode);
		return m.matches();
	}

	/**
	 * 下划线转驼峰法
	 * 
	 * @param line
	 *            源字符串
	 * @param smallCamel
	 *            大小驼峰,是否为小驼峰
	 * @return 转换后的字符串
	 */
	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0))
					: Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰法转下划线
	 * 
	 * @param line
	 *            源字符串
	 * @return 转换后的字符串
	 */
	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}

	/**
	 * 省市区拼接
	 * 
	 * @param province
	 * @param city
	 * @param borough
	 * @param splitChar
	 *            拼接字符，如输入"-"，则省-市-区，默认为"-"
	 * @return
	 */
	public static String splitPlace(String province, String city, String borough, String splitChar) {
		StringBuilder sb = new StringBuilder(30);
		if (StringUtils.isEmpty(splitChar)) {
			splitChar = "-";
		}
		if (StringUtils.isNotBlank(borough)) {
			sb.append(province);
			sb.append(splitChar);
			sb.append(city);
			sb.append(splitChar);
			sb.append(borough);
		} else if (StringUtils.isNotBlank(city)) {
			sb.append(province);
			sb.append(splitChar);
			sb.append(city);
		} else {
			sb.append(province);
		}
		if (sb.toString().equals("null")) {
			sb.setLength(0);
		}
		return sb.toString();
	}

	/**
	 * Object对象转成List
	 * 
	 * @param obj
	 * @return
	 */
	public static List<String> objToList(Object obj) {
		if (obj == null || "".equals(obj)) {
			return Collections.emptyList();
		} else {
			return Arrays.asList(obj.toString().split(","));
		}
	}

	/**
	 * 将obj转成字符串，如果长度小于totalLength，则在前面添加paddingStr，直到长度大于等于totalLength
	 * <p>
	 * 如果paddingStr==null，则返回String.valueOf(obj)
	 * 
	 * @param obj
	 *            原值
	 * @param totalLength
	 *            字符串最小长度
	 * @param paddingStr
	 *            追加字符串
	 * @return
	 */
	public static String paddingLeft(Object obj, int totalLength, String paddingStr) {
		String str = obj == null ? "" : obj.toString();
		while (StringUtils.isNotEmpty(paddingStr) && str.length() < totalLength) {
			str = paddingStr + str;
		}
		return str;
	}

	/**
	 * 将obj转成字符串，如果长度小于totalLength，则在后面添加paddingStr，直到长度大于等于totalLength
	 * <p>
	 * 如果paddingStr==null，则返回String.valueOf(obj)
	 * 
	 * @param obj
	 *            原值
	 * @param totalLength
	 *            字符串最小长度
	 * @param paddingStr
	 *            追加字符串
	 * @return
	 */
	public static String paddingRight(Object obj, int totalLength, String paddingStr) {
		String str = obj == null ? "" : obj.toString();
		while (StringUtils.isNotEmpty(paddingStr) && str.length() < totalLength) {
			str += paddingStr;
		}
		return str;
	}

	/**
	 * 将字母转成数字（excel列号转成数字索引），不合法字母将返回-1，不区分大小写
	 * <p>
	 * A->0，B->1，Z->25，AA->26， AB->27……
	 * 
	 * @param alpha
	 */
	public static int alphaToNumber(String alpha) {
		if (StringUtils.isBlank(alpha)) {
			return -1;
		}
		alpha = alpha.toUpperCase();
		if (!alpha.matches("^[A-Z]+$")) {
			return -1;
		}
		int number = 0;
		char[] chars = alpha.toCharArray();
		for (char c : chars) {
			number = 1 + number * 26 + c - 'A';
		}
		number--;// 索引从0开始，所以要减1
		return number;
	}

	/**
	 * 将字符串转成数字，如果无法转换，则返回0
	 * 
	 * @param str
	 *            字符串类型的数字
	 * @return
	 */
	public static int parseInt(String str) {
		if (StringUtils.isBlank(str)) {
			return 0;
		}
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 将字符串转成浮点数，如果无法转换，则返回0.0
	 * 
	 * @param str
	 * @return
	 */
	public static double parseDouble(String str) {
		if (StringUtils.isBlank(str)) {
			return 0d;
		}
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			e.printStackTrace();
			return 0d;
		}
	}

	/**
	 * 将字符串转成日期+时间类型，如果无法转换，则返回null
	 * 
	 * @param str
	 * @return
	 */
	public static LocalDateTime parseLocalDateTime(String str, String pattern) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return LocalDateTime.parse(str.replace("T", " "), DateTimeFormatter.ofPattern(pattern));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符串转成日期类型，如果无法转换，则返回null
	 * 
	 * @param str
	 * @return
	 */
	public static LocalDate parseLocalDate(String str, String pattern) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符串转成时间类型，如果无法转换，则返回null
	 * 
	 * @param str
	 * @return
	 */
	public static LocalTime parseLocalTime(String str, String pattern) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return LocalTime.parse(str, DateTimeFormatter.ofPattern(pattern));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toString(Object obj) {
		return obj == null ? null : obj.toString();
	}

	public static String stringToNumberTest(String string) {
		String[] as = findAllNumber(string);
		for (String a : as) {
			if (a.length() > 0) {
				string = string.replaceAll(a, numberToChinese(a));
			}
		}
		return string;
	}
	public static String numberToChinese(String string) {
		StringBuilder result = new StringBuilder();
		int n = string.length();
		for (int i = 0; i < n; i++) {
			int num = string.charAt(i) - '0';
			if (i != n - 1 && num != 0) {
				result.append(NUMBER_ARR[num]).append(NUMBER_UNIT_ARR[n - 2 - i]);
			} else {
				result.append(NUMBER_ARR[num]);
			}
		}
		System.out.println(result);
		return result.toString();

	}
	public static String[] findAllNumber(String dd) {
		dd = dd.replaceAll("\\D", "_").replace("_+", "_");
		return dd.split("_+");
	}
}
