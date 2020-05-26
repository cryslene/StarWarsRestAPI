package com.apisw.starwars.services;

import java.util.Arrays;
import java.util.Map;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.apisw.starwars.plan.MappingApiSw;

//Serviço de controle da Api pública do Star Wars
// encontrada em (https://swapi.dev/about)

@Service
public class PlanetaServiceRepoApi {

	final static String url = "https://swapi.dev/api/planets/";
	   
	private CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
	private HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	private RestTemplate restTemplate;
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<String> entity;
	
	
	public PlanetaServiceRepoApi() {
		this.requestFactory.setHttpClient(httpClient);
		this.restTemplate = new RestTemplate(requestFactory);
		this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		this.entity = new HttpEntity<String>(headers);
		
	}
	
	public HttpEntity<String> geraHeader(){
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return entity;
	}
	
	public MappingApiSw buscarPorNome(String nome) {
		UriComponents swApiUrl = UriComponentsBuilder.newInstance().scheme("https").host("swapi.dev").path("/api/planets/").query("search={nome}").buildAndExpand(nome);
		MappingApiSw response = restTemplate.getForObject(swApiUrl.toString(), MappingApiSw.class);
		return response;
	}
	
	@Cacheable
	public Map<String, Object> buscarPorID(int id) {
		UriComponents swApiUrl = UriComponentsBuilder.newInstance().scheme("https").host("swapi.dev").path("/api/planets/{id}").buildAndExpand(id);
		ResponseEntity<Map<String, Object>> response = restTemplate.exchange(swApiUrl.toString(), HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {});
		return response.getBody();
	}
	
}
