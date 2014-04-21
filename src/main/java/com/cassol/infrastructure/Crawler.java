package com.cassol.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class Crawler {

	public Crawler() throws ClientProtocolException, IOException {
//		start();
	}

	// @Scheduled(fixedDelay=1000)
	private void start() {
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		try {
			System.out.println("*************** INICIANDO CAPTURA **********");
			URI uri = new URI("http://portal.cfm.org.br/index.php?medicosNome=&medicosCRM=&medicosUF=AC&medicosMunicipios=&medicosSituacao=&medicosTipoInscricao=&medicosEspecialidade=&buscaEfetuada=true&option=com_medicos#buscaMedicos");
			String page = requestAsString(uri);
			Elements elemenst = Jsoup.parse(page).select(".tableHeaderMedicos");

			for (int i = 0; i < elemenst.size(); i++) {
				String doctorUri = Jsoup.parse(elemenst.get(i).toString())
						.select("a").attr("href");

				getDoctorAttributes(doctorUri);
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// }
		// }).start();
	}

	private void getDoctorAttributes(String doctorUri)
			throws URISyntaxException {
		URI uri = new URI("http://portal.cfm.org.br/index.php/"
				+ doctorUri);
		String page = requestAsString(uri);
		Elements elemenst = Jsoup.parse(page).select(
				".conteudo .lista_tipo2 .medico_busca_campo1");
	}

	public String requestAsString(URI uri) {

		for (int i = 0; i < 10; i++) {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			get.getParams().setParameter("http.socket.timeout",
					new Integer(30000));
			try {
				get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				get.setHeader("Accept-Encoding", "gzip,deflate,sdch");
				get.setHeader("Host", "portal.cfm.org.br");
				get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");
				get.addHeader("Access-Control-Allow-Origin", "*");

				HttpResponse response = client.execute(get);

				ResponseHandler<String> stringHandler = new BasicResponseHandler();
				return stringHandler.handleResponse(response);
				
//				
//				return EntityUtils.toString(response.getEntity(), "US-ASCII");
//				BufferedReader rd = new BufferedReader(new InputStreamReader(response
//						.getEntity().getContent()));
//
//				StringBuffer result = new StringBuffer();
//				String line = "";
//				while ((line = rd.readLine()) != null) {
//					result.append(line);
//				}
//				return result.toString();

			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					throw new RuntimeException();
				}
			}
		}
		return null;
	}

	public void requestJson() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://portal.cfm.org.br/index.php");
		
		get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		get.setHeader("Accept-Encoding", "gzip,deflate,sdch");
		get.setHeader("Host", "portal.cfm.org.br");
		get.setHeader("Referer", "http://portal.cfm.org.br/index.php?option=com_medicos&Itemid=59");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");

		HttpResponse response = client.execute(get);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		JSONObject o = new JSONObject(result.toString());
		o.get("");
	}

}
