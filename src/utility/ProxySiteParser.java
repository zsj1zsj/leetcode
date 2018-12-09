package utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProxySiteParser {

	
//	String siteUrl = "https://hidemy.name/en/proxy-list/?maxtime=1000&type=hs#list";
	String siteUrl = "https://hidemy.name/en/proxy-list/?type=hs#list";

	public Document fetchDocument(String url) throws IOException {
		Connection conn = Jsoup.connect(url);
		cloudflare cf = new cloudflare(url);
		cf.setUA("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
		Map<String, String> cookies = cf.List2Map(cf.cookies());

		Response res = conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
				.cookies(cookies).execute();
		Document doc = res.parse();
		return doc;
	}

	public List<ProxyItem> getProxyList(String onePage) throws IOException {
		Document onePagedoc = fetchDocument(onePage);
		Elements eles = onePagedoc.select("table.proxy__t>tbody>tr");
		List<ProxyItem> proxyList = new ArrayList<ProxyItem>();

		for (Element ele : eles) {
			String ip = ele.select("tr>td:nth-child(1)").text();
			String port = ele.select("tr>td:nth-child(2)").text();
			ProxyItem proxy = new ProxyItem(ip, port);
			proxyList.add(proxy);
		}

		return proxyList;
	}

	public List<String> getPages() throws IOException {
		Document doc = fetchDocument(siteUrl);
		Elements eles = doc.select(
				"#global-wrapper>#content-section>section.proxy>div.proxy__in>div.proxy__pagination>ul>li:not(.arrow__right)");
		
		List<String> pagesUrl = new ArrayList<>();

		for (Element pages : eles) {
			String href = pages.select("li>a").attr("abs:href");
			pagesUrl.add(href);
			System.out.println(href);
		}
		return pagesUrl;
	}

	public static void main(String[] args) throws IOException {
		ProxySiteParser parser = new ProxySiteParser();
		List<ProxyItem> proxies = new ArrayList<>();
		for (String url : parser.getPages()) {
			proxies.addAll(parser.getProxyList(url));
		}

		SqliteJdbc jdbc = new SqliteJdbc();
		jdbc.connect();
		for (ProxyItem item : proxies) {
			jdbc.insert(item.getIp(), item.getPort(), LocalDateTime.now());
		}

		// System.out.println(proxies.size());
	}
}

class ProxyItem {
	private String ip;
	private String port;

	public ProxyItem(String ip, String port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}