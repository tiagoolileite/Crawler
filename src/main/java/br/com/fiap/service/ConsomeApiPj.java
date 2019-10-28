package br.com.fiap.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.fiap.model.PJJsonModel;

public class ConsomeApiPj {
	public List<PJJsonModel> ConsomeApiPjTodos() throws IOException {
		String url = "http://localhost:8082/getPessoasJ/";
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PJJsonModel>>(){}.getType();
		List<PJJsonModel> pessoasJ = gson.fromJson(content, listType);
		
		return pessoasJ;
	}
	public List<PJJsonModel> ConsomeApiCnpj(String cnpj) throws IOException {
		String url = "http://localhost:8082/getPessoasJ/cnpj/" + cnpj;
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PJJsonModel>>(){}.getType();
		List<PJJsonModel> pessoasJ = gson.fromJson(content, listType);
		
		return pessoasJ;
	}
	
	public List<PJJsonModel> ConsomeApiAguardando(String status) throws IOException {
		String url = "http://localhost:8082/getPessoasJ/status/" + status;
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PJJsonModel>>(){}.getType();
		List<PJJsonModel> pessoasJ = gson.fromJson(content, listType);
		
		return pessoasJ;
	}
}
