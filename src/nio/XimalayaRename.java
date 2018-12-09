package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XimalayaRename {
	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<String>();

		list.add("一千二百三十四");
		list.add("一千");

		for (String s : list)
			c2a(s);

		List<Path> ll = Files.list(Paths.get("e:\\ximalaya\\听世界-战国\\")).collect(Collectors.toList());
		List<String> spaths = new ArrayList<>();
		for (Path pp : ll) {
			spaths.add(pp.toAbsolutePath().toString());
			Pattern p = Pattern.compile("第([^x00-xff]+)集");
			Matcher match = p.matcher(spaths.get(spaths.size() - 1));
			while (match.find()) {
				System.out.print(spaths.get(spaths.size() - 1));
				System.out.print(" : ");
//				System.out.println(c2a(match.group(1)));
				System.out.println(spaths.get(spaths.size() - 1).replaceAll(match.group(1), String.valueOf((c2a(match.group(1))))));
				
				File oldfile =new File(spaths.get(spaths.size() - 1));
				File newfile =new File(spaths.get(spaths.size() - 1).replaceAll(match.group(1), String.valueOf((c2a(match.group(1))))));

				if(oldfile.renameTo(newfile)){
					System.out.println("Rename succesful");
				}else{
					System.out.println("Rename failed");
				}
			}
		}

	}

	static int c2a(String input) {
		char[] NumBit = { '十', '百', '千' };
		HashMap<Character, Integer> numbers = new HashMap<>();
		numbers.put('一', 1);
		numbers.put('二', 2);
		numbers.put('三', 3);
		numbers.put('四', 4);
		numbers.put('五', 5);
		numbers.put('六', 6);
		numbers.put('七', 7);
		numbers.put('八', 8);
		numbers.put('九', 9);

		String middlevalue = new String(input);
		String output = "";

		int thousand = 0;
		int hundred = 0;
		int ten = 0;
		int unit = 0;

		// thousand
		if (input.indexOf("千") >= 0) {
			thousand = numbers.get(input.charAt(input.indexOf("千") - 1)) * 1000;
			// System.out.println(thousand);
			middlevalue = middlevalue.substring(input.indexOf("千") + 1);
		} else {
			// System.out.println("无千");
		}

		// hundred
		if (middlevalue.indexOf("百") >= 0) {
			if (middlevalue.indexOf("百") == 0) {
				hundred = 100;
			} else {
				hundred = numbers.get(input.charAt(input.indexOf("百") - 1)) * 100;
			}
			// System.out.println(hundred);
			middlevalue = middlevalue.substring(middlevalue.indexOf("百") + 1);
		} else {
			// System.out.println("无百");
			if (middlevalue.length() > 0)
				if (middlevalue.charAt(0) == '零')
					middlevalue = middlevalue.substring(1);
		}

		// ten
		if (middlevalue.indexOf("十") >= 0) {
			if (middlevalue.indexOf("十") == 0) {
				ten = 10;
			} else {
				ten = numbers.get(input.charAt(input.indexOf("十") - 1)) * 10;
			}
			// System.out.println(ten);
			middlevalue = middlevalue.substring(middlevalue.indexOf("十") + 1);
		} else {
			// System.out.println("无十");
			if (middlevalue.length() > 0)
				if (middlevalue.charAt(0) == '零')
					middlevalue = middlevalue.substring(1);
		}

		// unit
		if (middlevalue.length() > 0) {
			unit = numbers.get(middlevalue.charAt(0));
			// System.out.println(unit);
		} else {
			// System.out.println("无个位");
		}

		return thousand + hundred + ten + unit;
	}

}
