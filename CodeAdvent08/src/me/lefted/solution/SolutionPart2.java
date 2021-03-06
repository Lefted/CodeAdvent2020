package me.lefted.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPart2 {

    public static boolean[] visited;

    public static void main(String[] args) {
	String input = "acc +37\r\n" + "acc -4\r\n" + "nop +405\r\n" + "jmp +276\r\n" + "acc +39\r\n" + "acc +40\r\n" + "acc -3\r\n" + "jmp +231\r\n"
	    + "acc +44\r\n" + "acc +12\r\n" + "jmp +505\r\n" + "acc +35\r\n" + "jmp +282\r\n" + "acc +23\r\n" + "jmp +598\r\n" + "nop +392\r\n" + "acc +18\r\n"
	    + "acc +44\r\n" + "acc +18\r\n" + "jmp +297\r\n" + "nop +460\r\n" + "jmp +152\r\n" + "nop +541\r\n" + "acc +33\r\n" + "jmp -11\r\n" + "acc -5\r\n"
	    + "acc +9\r\n" + "jmp +327\r\n" + "acc +30\r\n" + "acc -1\r\n" + "acc -3\r\n" + "jmp +50\r\n" + "acc +22\r\n" + "acc +18\r\n" + "acc +33\r\n"
	    + "acc +37\r\n" + "jmp +57\r\n" + "acc -17\r\n" + "acc -6\r\n" + "acc -2\r\n" + "jmp +535\r\n" + "acc -15\r\n" + "jmp +279\r\n" + "acc +34\r\n"
	    + "acc +44\r\n" + "acc +41\r\n" + "jmp +349\r\n" + "acc +2\r\n" + "acc +6\r\n" + "nop +351\r\n" + "nop +252\r\n" + "jmp +505\r\n" + "jmp +1\r\n"
	    + "jmp +1\r\n" + "nop +61\r\n" + "jmp +524\r\n" + "nop +351\r\n" + "jmp +399\r\n" + "acc +1\r\n" + "nop +397\r\n" + "acc +39\r\n" + "nop +141\r\n"
	    + "jmp +134\r\n" + "acc +46\r\n" + "acc +14\r\n" + "acc +26\r\n" + "jmp +236\r\n" + "acc +7\r\n" + "acc -6\r\n" + "acc +35\r\n" + "jmp +397\r\n"
	    + "acc +15\r\n" + "jmp +140\r\n" + "acc +3\r\n" + "acc -4\r\n" + "acc +37\r\n" + "acc +12\r\n" + "jmp +86\r\n" + "jmp +416\r\n" + "jmp +1\r\n"
	    + "jmp +55\r\n" + "acc -19\r\n" + "jmp +536\r\n" + "jmp +1\r\n" + "acc -11\r\n" + "acc +15\r\n" + "jmp -61\r\n" + "acc +25\r\n" + "jmp -25\r\n"
	    + "acc +50\r\n" + "acc +43\r\n" + "jmp +1\r\n" + "jmp +140\r\n" + "acc +46\r\n" + "nop -53\r\n" + "acc +1\r\n" + "nop +440\r\n" + "jmp +488\r\n"
	    + "jmp +396\r\n" + "nop +443\r\n" + "acc +41\r\n" + "jmp +168\r\n" + "acc +25\r\n" + "nop +383\r\n" + "acc +12\r\n" + "acc -19\r\n" + "jmp +21\r\n"
	    + "acc +29\r\n" + "acc +30\r\n" + "jmp +497\r\n" + "jmp +502\r\n" + "jmp +417\r\n" + "nop +351\r\n" + "acc -15\r\n" + "jmp +243\r\n" + "acc +21\r\n"
	    + "acc +16\r\n" + "jmp +332\r\n" + "acc +28\r\n" + "acc +22\r\n" + "acc +38\r\n" + "jmp +476\r\n" + "acc +8\r\n" + "acc -11\r\n" + "jmp +458\r\n"
	    + "acc +9\r\n" + "jmp +246\r\n" + "acc +40\r\n" + "acc +31\r\n" + "acc +26\r\n" + "jmp +218\r\n" + "acc +27\r\n" + "acc +9\r\n" + "nop +347\r\n"
	    + "jmp +478\r\n" + "nop +28\r\n" + "nop +106\r\n" + "acc +25\r\n" + "acc -15\r\n" + "jmp +397\r\n" + "acc +31\r\n" + "jmp +231\r\n" + "acc -4\r\n"
	    + "nop +136\r\n" + "acc +14\r\n" + "jmp +181\r\n" + "jmp +361\r\n" + "acc +16\r\n" + "acc +11\r\n" + "jmp -108\r\n" + "nop +299\r\n" + "acc +21\r\n"
	    + "acc -2\r\n" + "jmp -106\r\n" + "jmp +246\r\n" + "acc +31\r\n" + "jmp +407\r\n" + "jmp +377\r\n" + "acc +43\r\n" + "acc -12\r\n" + "nop +142\r\n"
	    + "acc +8\r\n" + "jmp -91\r\n" + "jmp +1\r\n" + "acc +34\r\n" + "acc +5\r\n" + "acc +31\r\n" + "jmp +12\r\n" + "acc +34\r\n" + "acc +7\r\n"
	    + "acc +34\r\n" + "acc +20\r\n" + "jmp -45\r\n" + "acc -11\r\n" + "acc +41\r\n" + "acc +10\r\n" + "jmp +310\r\n" + "nop -106\r\n" + "jmp -36\r\n"
	    + "acc +23\r\n" + "acc +46\r\n" + "acc +46\r\n" + "jmp +112\r\n" + "acc +41\r\n" + "nop +179\r\n" + "acc +17\r\n" + "nop +356\r\n" + "jmp +147\r\n"
	    + "acc +42\r\n" + "nop +49\r\n" + "jmp +119\r\n" + "acc +0\r\n" + "acc +7\r\n" + "acc -18\r\n" + "acc -8\r\n" + "jmp +11\r\n" + "acc +12\r\n"
	    + "acc +38\r\n" + "acc +39\r\n" + "jmp +281\r\n" + "nop +186\r\n" + "jmp +162\r\n" + "acc +44\r\n" + "acc +20\r\n" + "jmp +153\r\n" + "jmp +395\r\n"
	    + "acc +49\r\n" + "jmp +1\r\n" + "acc +2\r\n" + "jmp +1\r\n" + "jmp -31\r\n" + "jmp +301\r\n" + "nop +97\r\n" + "jmp -102\r\n" + "jmp +262\r\n"
	    + "acc +28\r\n" + "acc -15\r\n" + "acc +44\r\n" + "acc -13\r\n" + "jmp +191\r\n" + "jmp +281\r\n" + "acc +36\r\n" + "acc +1\r\n" + "nop +15\r\n"
	    + "jmp +211\r\n" + "acc +6\r\n" + "acc -4\r\n" + "jmp +42\r\n" + "acc +34\r\n" + "acc +0\r\n" + "jmp +104\r\n" + "jmp +311\r\n" + "jmp +84\r\n"
	    + "acc +43\r\n" + "acc -8\r\n" + "acc -10\r\n" + "acc +38\r\n" + "jmp -90\r\n" + "acc +49\r\n" + "jmp +303\r\n" + "nop +132\r\n" + "jmp +301\r\n"
	    + "nop +60\r\n" + "acc +37\r\n" + "nop +96\r\n" + "jmp +182\r\n" + "acc +16\r\n" + "acc +18\r\n" + "nop +152\r\n" + "acc +19\r\n" + "jmp +325\r\n"
	    + "jmp -63\r\n" + "acc +28\r\n" + "jmp +56\r\n" + "acc +18\r\n" + "acc +29\r\n" + "acc +33\r\n" + "jmp -115\r\n" + "acc +47\r\n" + "acc +19\r\n"
	    + "jmp +1\r\n" + "nop +41\r\n" + "jmp +1\r\n" + "jmp -207\r\n" + "nop -62\r\n" + "acc -9\r\n" + "acc +42\r\n" + "acc -12\r\n" + "jmp -56\r\n"
	    + "acc +28\r\n" + "jmp -163\r\n" + "acc +25\r\n" + "acc +17\r\n" + "jmp -217\r\n" + "acc +7\r\n" + "jmp +272\r\n" + "acc +43\r\n" + "acc +22\r\n"
	    + "jmp +70\r\n" + "acc -17\r\n" + "jmp -117\r\n" + "acc +24\r\n" + "acc +26\r\n" + "nop -275\r\n" + "jmp -46\r\n" + "nop +87\r\n" + "acc +19\r\n"
	    + "acc +28\r\n" + "jmp -34\r\n" + "acc +4\r\n" + "acc +9\r\n" + "acc +6\r\n" + "jmp +1\r\n" + "jmp +28\r\n" + "acc -6\r\n" + "nop -67\r\n"
	    + "acc -10\r\n" + "jmp +271\r\n" + "acc +40\r\n" + "acc +25\r\n" + "acc -4\r\n" + "jmp -63\r\n" + "acc +46\r\n" + "jmp +78\r\n" + "acc +41\r\n"
	    + "nop -126\r\n" + "nop +70\r\n" + "jmp +1\r\n" + "jmp +172\r\n" + "nop +270\r\n" + "jmp +30\r\n" + "jmp +1\r\n" + "acc +38\r\n" + "nop +68\r\n"
	    + "acc +29\r\n" + "jmp +253\r\n" + "acc -18\r\n" + "jmp -89\r\n" + "acc +18\r\n" + "acc +30\r\n" + "jmp +147\r\n" + "acc +24\r\n" + "acc +11\r\n"
	    + "acc +50\r\n" + "jmp -225\r\n" + "jmp -210\r\n" + "acc -18\r\n" + "acc +1\r\n" + "acc +38\r\n" + "jmp +1\r\n" + "jmp -79\r\n" + "acc +45\r\n"
	    + "acc +12\r\n" + "jmp +209\r\n" + "jmp -207\r\n" + "acc +32\r\n" + "acc +4\r\n" + "acc +32\r\n" + "acc +14\r\n" + "jmp +83\r\n" + "acc +13\r\n"
	    + "acc +1\r\n" + "acc +46\r\n" + "acc +38\r\n" + "jmp +28\r\n" + "nop +153\r\n" + "acc -17\r\n" + "jmp -73\r\n" + "acc +11\r\n" + "jmp +248\r\n"
	    + "acc +29\r\n" + "acc +45\r\n" + "acc +16\r\n" + "jmp +96\r\n" + "jmp -273\r\n" + "acc +34\r\n" + "jmp +87\r\n" + "nop +99\r\n" + "acc -3\r\n"
	    + "jmp -74\r\n" + "acc +12\r\n" + "nop -119\r\n" + "jmp -141\r\n" + "acc -18\r\n" + "nop -79\r\n" + "acc +1\r\n" + "acc +6\r\n" + "jmp +9\r\n"
	    + "acc +3\r\n" + "acc +44\r\n" + "acc +39\r\n" + "jmp -165\r\n" + "acc +6\r\n" + "jmp +44\r\n" + "acc +25\r\n" + "jmp -133\r\n" + "acc +0\r\n"
	    + "jmp +14\r\n" + "jmp +1\r\n" + "acc +1\r\n" + "jmp -223\r\n" + "jmp +71\r\n" + "nop -1\r\n" + "acc +22\r\n" + "acc +11\r\n" + "jmp -274\r\n"
	    + "jmp -330\r\n" + "acc +45\r\n" + "jmp +1\r\n" + "acc +15\r\n" + "jmp -158\r\n" + "jmp -128\r\n" + "acc +50\r\n" + "acc +26\r\n" + "jmp -73\r\n"
	    + "nop +99\r\n" + "jmp +71\r\n" + "acc +35\r\n" + "acc +7\r\n" + "jmp +192\r\n" + "acc +13\r\n" + "jmp +190\r\n" + "acc +4\r\n" + "acc -1\r\n"
	    + "acc +40\r\n" + "acc -15\r\n" + "jmp +50\r\n" + "acc +29\r\n" + "jmp -337\r\n" + "jmp -75\r\n" + "acc +41\r\n" + "jmp +1\r\n" + "jmp -387\r\n"
	    + "acc +28\r\n" + "acc +18\r\n" + "acc +19\r\n" + "jmp -62\r\n" + "nop -196\r\n" + "jmp -410\r\n" + "jmp +1\r\n" + "acc -17\r\n" + "jmp -267\r\n"
	    + "acc +22\r\n" + "jmp -301\r\n" + "nop -98\r\n" + "acc -15\r\n" + "jmp -124\r\n" + "acc +45\r\n" + "acc -18\r\n" + "acc +15\r\n" + "acc +42\r\n"
	    + "jmp -296\r\n" + "nop -10\r\n" + "acc +29\r\n" + "jmp -371\r\n" + "acc +3\r\n" + "jmp +1\r\n" + "nop +61\r\n" + "acc +5\r\n" + "jmp -361\r\n"
	    + "acc -5\r\n" + "nop -326\r\n" + "jmp -379\r\n" + "acc -10\r\n" + "jmp +1\r\n" + "acc +44\r\n" + "jmp -231\r\n" + "acc +3\r\n" + "jmp -94\r\n"
	    + "acc +1\r\n" + "jmp +113\r\n" + "jmp -336\r\n" + "acc +4\r\n" + "jmp -299\r\n" + "acc -13\r\n" + "jmp +1\r\n" + "acc +13\r\n" + "jmp +143\r\n"
	    + "acc -11\r\n" + "acc -19\r\n" + "acc +18\r\n" + "nop -390\r\n" + "jmp -27\r\n" + "acc +42\r\n" + "jmp -232\r\n" + "acc +15\r\n" + "jmp -228\r\n"
	    + "acc +21\r\n" + "acc +39\r\n" + "acc +47\r\n" + "acc +6\r\n" + "jmp +57\r\n" + "acc +28\r\n" + "acc +27\r\n" + "acc +50\r\n" + "jmp -397\r\n"
	    + "acc +12\r\n" + "jmp -445\r\n" + "acc +30\r\n" + "jmp -352\r\n" + "acc -4\r\n" + "acc +26\r\n" + "acc +48\r\n" + "jmp +1\r\n" + "jmp -205\r\n"
	    + "jmp +22\r\n" + "nop -284\r\n" + "acc -1\r\n" + "nop -361\r\n" + "acc +0\r\n" + "jmp -368\r\n" + "acc -17\r\n" + "nop -223\r\n" + "jmp -41\r\n"
	    + "acc +4\r\n" + "acc +46\r\n" + "jmp +79\r\n" + "jmp -370\r\n" + "jmp -260\r\n" + "acc +42\r\n" + "jmp -14\r\n" + "acc +30\r\n" + "acc +50\r\n"
	    + "acc +13\r\n" + "jmp -61\r\n" + "acc +46\r\n" + "jmp -63\r\n" + "nop -55\r\n" + "nop -320\r\n" + "jmp -11\r\n" + "acc +10\r\n" + "jmp -424\r\n"
	    + "jmp -11\r\n" + "acc +3\r\n" + "jmp -71\r\n" + "acc +42\r\n" + "acc -13\r\n" + "jmp +4\r\n" + "nop -155\r\n" + "nop -138\r\n" + "jmp +62\r\n"
	    + "acc +11\r\n" + "acc +19\r\n" + "acc +15\r\n" + "acc +17\r\n" + "jmp -73\r\n" + "acc -11\r\n" + "jmp -273\r\n" + "acc +8\r\n" + "acc +6\r\n"
	    + "acc -7\r\n" + "acc +41\r\n" + "jmp -311\r\n" + "jmp -111\r\n" + "jmp -260\r\n" + "jmp +50\r\n" + "jmp -60\r\n" + "jmp +1\r\n" + "nop -89\r\n"
	    + "acc +36\r\n" + "acc +14\r\n" + "jmp -220\r\n" + "nop -415\r\n" + "acc +28\r\n" + "jmp -402\r\n" + "acc +41\r\n" + "jmp -165\r\n" + "acc +9\r\n"
	    + "acc -13\r\n" + "acc -18\r\n" + "acc +18\r\n" + "jmp -504\r\n" + "acc -9\r\n" + "acc +29\r\n" + "acc +44\r\n" + "jmp -444\r\n" + "acc +5\r\n"
	    + "acc +47\r\n" + "jmp -545\r\n" + "acc +23\r\n" + "acc +7\r\n" + "nop -240\r\n" + "jmp -320\r\n" + "jmp -141\r\n" + "jmp +1\r\n" + "acc +28\r\n"
	    + "nop -287\r\n" + "jmp -118\r\n" + "acc +44\r\n" + "acc -7\r\n" + "jmp -550\r\n" + "acc +10\r\n" + "acc +20\r\n" + "acc -3\r\n" + "jmp -401\r\n"
	    + "acc +45\r\n" + "acc +36\r\n" + "jmp -375\r\n" + "jmp -485\r\n" + "acc +9\r\n" + "jmp -338\r\n" + "jmp -510\r\n" + "jmp -196\r\n" + "acc -16\r\n"
	    + "jmp -372\r\n" + "acc +0\r\n" + "jmp -380\r\n" + "acc -3\r\n" + "nop -473\r\n" + "nop -361\r\n" + "jmp -311\r\n" + "acc +0\r\n" + "nop +20\r\n"
	    + "jmp -436\r\n" + "acc +9\r\n" + "jmp +1\r\n" + "jmp -215\r\n" + "acc +19\r\n" + "jmp -451\r\n" + "jmp -43\r\n" + "acc -13\r\n" + "acc -10\r\n"
	    + "acc -5\r\n" + "jmp -208\r\n" + "acc -11\r\n" + "jmp -156\r\n" + "acc +11\r\n" + "acc -2\r\n" + "nop -357\r\n" + "jmp -73\r\n" + "acc +21\r\n"
	    + "jmp -159\r\n" + "acc +28\r\n" + "acc -16\r\n" + "acc +12\r\n" + "acc +1\r\n" + "jmp -282\r\n" + "jmp -131\r\n" + "acc -11\r\n" + "acc +45\r\n"
	    + "acc +0\r\n" + "acc +28\r\n" + "jmp +1\r\n";

	String test = "nop +0\r\n" + "acc +1\r\n" + "jmp +4\r\n" + "acc +3\r\n" + "jmp -3\r\n" + "acc -99\r\n" + "acc +1\r\n" + "jmp -4\r\n" + "acc +6";
	List<String> opcodes = Arrays.asList(input.split("\r\n"));
	visited = new boolean[opcodes.size()];
	int akku = 0;
	akku = tryCode(opcodes);

	System.out.println(String.format("Found %s", akku));
    }

    public static int executeCode(List<String> opcodes) {
	int akku = 0;
	for (int i = 0; i < visited.length; i++) {
	    visited[i] = false;
	}

	for (int programCounter = 0; programCounter < opcodes.size(); ++programCounter) {
	    String code = opcodes.get(programCounter);
	    String[] args = code.split(" ");

	    String opcode = args[0];
	    String param = args[1];

	    switch (opcode) {
	    case "nop":
		if (visited[programCounter])
		    return Integer.MIN_VALUE;
		visited[programCounter] = true;
		break;
	    case "acc":
		if (visited[programCounter])
		    return Integer.MIN_VALUE;
		visited[programCounter] = true;
		akku += Integer.parseInt(param);
		break;
	    case "jmp":
		if (visited[programCounter])
		    return Integer.MIN_VALUE;
		visited[programCounter] = true;
		programCounter += Integer.parseInt(param) - 1;
		break;
	    }
	}

	return akku;
    }

    public static int tryCode(List<String> opcodes) {
	List<String> working = new ArrayList(opcodes);
	int akku = 0;

	for (int i = 0; i < working.size(); ++i) {
	    String code = working.get(i);
	    String[] args = code.split(" ");
	    String opcode = args[0];
	    switch (opcode) {
	    case "jmp":
		working.set(i, code.replace("jmp", "nop"));
		break;
	    case "nop":
		working.set(i, code.replace("nop", "jmp"));
		break;
	    default:
		continue;
	    }

	    int result = executeCode(working);
	    if (result != Integer.MIN_VALUE) {
		return result;
	    }

	    working.clear();
	    working.addAll(opcodes);
	}
	return akku;
    }
}