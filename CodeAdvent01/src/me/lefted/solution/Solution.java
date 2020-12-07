package me.lefted.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Solution {

    public static void main(String[] args) {
	String inputStr = "1975\r\n" + "1600\r\n" + "113\r\n" + "1773\r\n" + "1782\r\n" + "1680\r\n" + "1386\r\n" + "1682\r\n" + "1991\r\n" + "1640\r\n"
	    + "1760\r\n" + "1236\r\n" + "1159\r\n" + "1259\r\n" + "1279\r\n" + "1739\r\n" + "1826\r\n" + "1888\r\n" + "1072\r\n" + "416\r\n" + "1632\r\n"
	    + "1656\r\n" + "1273\r\n" + "1631\r\n" + "1079\r\n" + "1807\r\n" + "1292\r\n" + "1128\r\n" + "1841\r\n" + "1915\r\n" + "1619\r\n" + "1230\r\n"
	    + "1950\r\n" + "1627\r\n" + "1966\r\n" + "774\r\n" + "1425\r\n" + "1983\r\n" + "1616\r\n" + "1633\r\n" + "1559\r\n" + "1925\r\n" + "960\r\n"
	    + "1407\r\n" + "1708\r\n" + "1211\r\n" + "1666\r\n" + "1910\r\n" + "1960\r\n" + "1125\r\n" + "1242\r\n" + "1884\r\n" + "1829\r\n" + "1881\r\n"
	    + "1585\r\n" + "1731\r\n" + "1753\r\n" + "1784\r\n" + "1095\r\n" + "1267\r\n" + "1756\r\n" + "1226\r\n" + "1107\r\n" + "1664\r\n" + "1710\r\n"
	    + "2000\r\n" + "1181\r\n" + "1997\r\n" + "1607\r\n" + "1889\r\n" + "1613\r\n" + "1859\r\n" + "1479\r\n" + "1763\r\n" + "1692\r\n" + "1967\r\n"
	    + "522\r\n" + "1719\r\n" + "1816\r\n" + "1714\r\n" + "1331\r\n" + "1976\r\n" + "1160\r\n" + "1899\r\n" + "1906\r\n" + "1783\r\n" + "1061\r\n"
	    + "2006\r\n" + "1993\r\n" + "1717\r\n" + "2009\r\n" + "1563\r\n" + "1733\r\n" + "1866\r\n" + "1651\r\n" + "1437\r\n" + "1517\r\n" + "1113\r\n"
	    + "1743\r\n" + "1240\r\n" + "1629\r\n" + "1868\r\n" + "1912\r\n" + "1296\r\n" + "1873\r\n" + "1673\r\n" + "1996\r\n" + "1814\r\n" + "1215\r\n"
	    + "1927\r\n" + "1956\r\n" + "1970\r\n" + "1887\r\n" + "1702\r\n" + "1495\r\n" + "1754\r\n" + "1621\r\n" + "1055\r\n" + "1538\r\n" + "1693\r\n"
	    + "1840\r\n" + "1685\r\n" + "1752\r\n" + "1933\r\n" + "1727\r\n" + "1648\r\n" + "1792\r\n" + "1734\r\n" + "1305\r\n" + "1446\r\n" + "1764\r\n"
	    + "1890\r\n" + "1904\r\n" + "1560\r\n" + "1698\r\n" + "1645\r\n" + "1214\r\n" + "1516\r\n" + "1064\r\n" + "1729\r\n" + "1835\r\n" + "1642\r\n"
	    + "1932\r\n" + "1683\r\n" + "962\r\n" + "1081\r\n" + "1943\r\n" + "1502\r\n" + "1622\r\n" + "196\r\n" + "1972\r\n" + "1916\r\n" + "1850\r\n"
	    + "1205\r\n" + "1971\r\n" + "1937\r\n" + "1575\r\n" + "1401\r\n" + "1351\r\n" + "2005\r\n" + "1917\r\n" + "1670\r\n" + "1388\r\n" + "1051\r\n"
	    + "1941\r\n" + "1751\r\n" + "1169\r\n" + "510\r\n" + "217\r\n" + "1948\r\n" + "1120\r\n" + "1635\r\n" + "1636\r\n" + "1511\r\n" + "1691\r\n"
	    + "1589\r\n" + "1410\r\n" + "1902\r\n" + "1572\r\n" + "1871\r\n" + "1423\r\n" + "1114\r\n" + "1806\r\n" + "1282\r\n" + "1193\r\n" + "1974\r\n"
	    + "388\r\n" + "1398\r\n" + "1992\r\n" + "1263\r\n" + "1786\r\n" + "1723\r\n" + "1206\r\n" + "1363\r\n" + "1177\r\n" + "1646\r\n" + "1231\r\n"
	    + "1140\r\n" + "1088\r\n" + "1322";
	List<String> input = Arrays.asList(inputStr.split("\r\n"));
	// StringBuffer buffer = new StringBuffer();
	// buffer.append("{");

	for (String string : input) {

	    int value = Integer.parseInt(string);

	    for (String string2 : input) {
		int value2 = Integer.parseInt(string2);

		for (String string3 : input) {
		    int value3 = Integer.parseInt(string3);

		    if (value + value2 + value3 == 2020) {
			System.out.println(value * value2 * value3);
		    }
		}
	    }
	}
    }
}
