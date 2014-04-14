package com.cassol.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.apache.http.client.ResponseHandler;
import org.springframework.stereotype.Component;


@Component
public class Crawler {
	
	public Crawler(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("*************** INICIANDO CAPTURA **********");
					URI uri = new URI("http://www.cadastronacionalmedico.org/medico/index.php?pagina=0");
					String page = asString(uri);
					Elements elemenst = Jsoup.parse(page).select(".conteudo .lista_tipo2 .medico_busca_campo1");
					
					for(int i =0; i < elemenst.size(); i++){
						System.out.println(elemenst.get(i));
					}
					
					
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				
			}
		}).start(); 
		
	}
	
	
	public String asString(URI uri) {


		for (int i = 0; i < 10; i++) {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			get.getParams().setParameter("http.socket.timeout", new Integer(30000));
			try {
				get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				get.setHeader("Accept-Encoding","gzip,deflate,sdch");
				get.setHeader("Host", "www.cadastronacionalmedico.org");
				get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");
				
				ResponseHandler<String> stringHandler = new BasicResponseHandler();
				return client.execute(get, stringHandler);
				
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


}
