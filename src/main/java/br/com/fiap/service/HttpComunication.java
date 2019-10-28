package br.com.fiap.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;

public class HttpComunication {
	public static void editStatusPf(PFJsonModel pf) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut put = new HttpPut("http://localhost:8082/getPessoasF/" + pf.getIdPf());
		put.setHeader("Accept", "application/json");
		put.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(put, responseHandler);
		System.out.println(responseBoyd);
	}
	
	public static void editStatusPferror(PFJsonModel pf) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:8082/getPessoasF/erro/" + pf.getIdPf());
		get.setHeader("Accept", "application/json");
		get.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(get, responseHandler);
		System.out.println(responseBoyd);
	}
	
	public static void editStatusPferrorFull(PFJsonModel pf) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:8082/getPessoasF/erroFull/" + pf.getIdPf());
		get.setHeader("Accept", "application/json");
		get.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(get, responseHandler);
		System.out.println(responseBoyd);
	}
	
	public static void editStatusPj(PJJsonModel pj) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut put = new HttpPut("http://localhost:8082/getPessoasJ/" + pj.getIdPj());
		put.setHeader("Accept", "application/json");
		put.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(put, responseHandler);
		System.out.println(responseBoyd);
	}
	public static void editStatusPjerror(PJJsonModel pj) throws IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:8082/getPessoasJ/erro" + pj.getIdPj());
		get.setHeader("Accept", "application/json");
		get.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(get, responseHandler);
		System.out.println(responseBoyd);
	}

	public static void editStatusPjerrorFull(PJJsonModel pj) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:8082/getPessoasJ/erroFull" + pj.getIdPj());
		get.setHeader("Accept", "application/json");
		get.setHeader("Content-type", "application/json");
		
		ResponseHandler<String> responseHandler = response -> {
		    int status = response.getStatusLine().getStatusCode();
		    if (status >= 200 && status < 300) {
		        HttpEntity entity = response.getEntity();
		        return entity != null ? EntityUtils.toString(entity) : null;
		    } else {
		        throw new ClientProtocolException("Unexpected response status: " + status);
		    }
		};
		
		String responseBoyd = httpclient.execute(get, responseHandler);
		System.out.println(responseBoyd);
	}
}
