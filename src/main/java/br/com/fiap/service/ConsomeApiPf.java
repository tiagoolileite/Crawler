package br.com.fiap.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.fiap.model.PFJsonModel;

public class ConsomeApiPf {
	
	
	public List<PFJsonModel> ConsomeApiPfTodos() throws IOException {
		String url = "http://localhost:8082/getPessoasF/";
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PFJsonModel>>(){}.getType();
		List<PFJsonModel> pessoasF = gson.fromJson(content, listType);
		
		return pessoasF;
	}
	public List<PFJsonModel> ConsomeApiCpf(String cpf) throws IOException {
		String url = "http://localhost:8082/getPessoasF/cpf/" + cpf;
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PFJsonModel>>(){}.getType();
		List<PFJsonModel> pessoasF = gson.fromJson(content, listType);
		
		return pessoasF;
	}
	
	public List<PFJsonModel> ConsomeApiAguardando(String status) throws IOException {
		String url = "http://localhost:8082/getPessoasF/status/" + status;
		String content = CapturaJson.fetchContent(url);
		Gson gson = new Gson();
		Type listType = new TypeToken<List<PFJsonModel>>(){}.getType();
		List<PFJsonModel> pessoasF = gson.fromJson(content, listType);
		
		return pessoasF;
	}
}
