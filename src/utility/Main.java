package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class Main {
	static Map<String, Integer> m = new HashMap<>();
	List<String> list = new ArrayList<>();

	public Main() {
		list.add("138.68.88.246:3240");
		list.add("70.169.70.90:80");
		list.add("111.67.71.12:8080");
		list.add("138.186.164.41:80");
		list.add("190.145.32.109:3128");
		list.add("202.83.162.214:8080");
		list.add("122.183.139.104:8080");
		list.add("45.6.216.66:80");
		list.add("95.30.250.92:8080");
		list.add("103.94.125.106:3128");
		list.add("144.217.48.73:8080");
		list.add("216.165.113.123:3128");
		list.add("45.77.71.109:3128");
		list.add("125.212.207.121:3128");
		list.add("13.73.25.58:80");
		list.add("203.30.254.107:53281");
		list.add("158.255.31.93:53281");
		list.add("180.210.205.53:3129");
		list.add("45.79.149.212:3128");
		list.add("128.199.189.94:8080");
		list.add("125.141.200.4:80");
		list.add("139.59.109.146:3128");
		list.add("42.104.84.107:8080");
		list.add("122.183.139.107:8080");
		list.add("190.7.112.18:3128");
		list.add("203.95.220.110:53281");
		list.add("138.0.152.164:3128");
		list.add("139.59.2.223:8888");
		list.add("125.141.200.21:80");
		list.add("122.183.139.105:8080");
		list.add("154.119.50.246:53281");
		list.add("52.163.62.13:80");
		list.add("91.207.185.40:53281");
		list.add("203.146.82.253:3128");
		list.add("199.195.253.124:3128");
		list.add("125.141.200.40:80");
		list.add("125.141.200.39:80");
		list.add("119.196.234.74:3128");
		list.add("34.216.139.102:1911");
		list.add("66.70.191.5:3128");
		list.add("149.202.38.124:32321");
		list.add("128.199.108.121:3128");
		list.add("37.17.177.197:3128");

		for (String addr : list) {
			m.put(addr.split(":")[0], Integer.parseInt(addr.split(":")[1]));
		}

	}

	boolean testProxy(String ipaddr, int port, String testUrl, String testKeyword) {
		// System.out.println(ipaddr + ":" + port);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipaddr, port));
		URLConnection conn;
		BufferedReader reader = null;

		String line = "";
		String content = "";

		try {
			conn = new URL(testUrl).openConnection(proxy);
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				content += line;
			}
			reader.close();
		} catch (IOException e) {
			// System.out.println(e.getMessage());
			return false;
		}

		if (line != "" && content.contains(testKeyword)) {
			// System.out.println(ipaddr + ": successed.");
			return true;
		}
		// System.out.println(ipaddr + ": failed.");
		return false;
	}

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		Main main = new Main();
		// System.out.println(main.testProxy("66.70.191.5", 3128));

		System.out.println("start from " + LocalTime.now());
		long start = System.nanoTime();
		m.entrySet().parallelStream()
				.filter(map -> main.testProxy(map.getKey(), map.getValue(), "http://www.baidu.com", "baidu.com"))
				.forEach(System.out::println);

		System.out.println("end " + LocalTime.now());
		System.out.println("Elapse " + (System.nanoTime() - start) / 1000_000_000 + "s");
		// main.testProxy("139.59.2.223",
		// 8888,"http://www.baidu.com","baidu.com");
		// main.testProxy("139.59.2.223",
		// 8888,"https://www.iplocation.net","139.59.2.223");
	}

}
