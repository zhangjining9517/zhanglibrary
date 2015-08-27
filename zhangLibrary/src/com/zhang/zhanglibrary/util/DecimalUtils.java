package com.zhang.zhanglibrary.util;

/**
 * 
 * class name：DecimalUtils description:Binary, hex, decimal conversion
 * 
 * @author zjn
 */
public class DecimalUtils {
	/**
	 * hex to binary
	 * 
	 * @param a
	 * @return
	 */
	public String HToB(String a) {
		String b = Integer.toBinaryString(Integer.valueOf(toD(a, 16)));
		return b;
	}

	/**
	 * binary to hex
	 * 
	 * @param a
	 * @return
	 */
	public String BToH(String a) {
		// binary to decimal decimal to hex
		String b = Integer.toHexString(Integer.valueOf(toD(a, 2)));
		return b;
	}

	/**
	 * Arbitrary hexadecimal number to a decimal number
	 * @param a
	 * @param b
	 * @return
	 */
	public String toD(String a, int b) {
		int r = 0;
		for (int i = 0; i < a.length(); i++) {
			r = (int) (r + formatting(a.substring(i, i + 1))
					* Math.pow(b, a.length() - i - 1));
		}
		return String.valueOf(r);
	}

	/**
	 * Will the hexadecimal letters converted to the corresponding Numbers
	 * 
	 * @param a
	 * @return
	 */
	public int formatting(String a) {
		int i = 0;
		for (int u = 0; u < 10; u++) {
			if (a.equals(String.valueOf(u))) {
				i = u;
			}
		}
		if (a.equals("a")) {
			i = 10;
		}
		if (a.equals("b")) {
			i = 11;
		}
		if (a.equals("c")) {
			i = 12;
		}
		if (a.equals("d")) {
			i = 13;
		}
		if (a.equals("e")) {
			i = 14;
		}
		if (a.equals("f")) {
			i = 15;
		}
		return i;
	}

	/**
	 * Will the number in the decimal into hexadecimal corresponding letter
	 * 
	 * @param a
	 * @return
	 */
	public String formattingH(int a) {
		String i = String.valueOf(a);
		switch (a) {
		case 10:
			i = "a";
			break;
		case 11:
			i = "b";
			break;
		case 12:
			i = "c";
			break;
		case 13:
			i = "d";
			break;
		case 14:
			i = "e";
			break;
		case 15:
			i = "f";
			break;
		}
		return i;
	}

	public static void main(String[] args) {
		DecimalUtils decimalUtils = new DecimalUtils();
		System.out.println(decimalUtils.toD("ff", 10));
	}
}
