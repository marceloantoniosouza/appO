package com.porto.appo.negocio.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.porto.appo.negocio.dto.ClienteDTO;

@Service
public class ClienteService {
	
	@Value("${url.appI}")
	private String variavelAcesso;

	public List<ClienteDTO> clientes() {
		List<ClienteDTO> list = new ArrayList<ClienteDTO>();

		list.add(new ClienteDTO(1, "Joao"));
		list.add(new ClienteDTO(2, "Maria"));
		list.add(new ClienteDTO(3, "Ana"));

		return list;
	}
	
	public List<ClienteDTO> clientesAppI() {
		List<ClienteDTO> list = new ArrayList<ClienteDTO>();

		list.add(new ClienteDTO(1, "Joao"));
		list.add(new ClienteDTO(2, "Maria"));
		list.add(new ClienteDTO(3, "Ana"));

		list.add(acessoClienteApiI());

		return list;
	}

	private ClienteDTO acessoClienteApiI() {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		ClienteDTO clienteDTO = null;
				
		try {
			HttpGet getRequest = new HttpGet(this.variavelAcesso);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = httpClient.execute(getRequest);
			int statusCode = response.getStatusLine().getStatusCode();

			System.out.println("statusCode: " + statusCode);
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}

			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);
			clienteDTO = new Gson().fromJson(apiOutput, ClienteDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Important: Close the connect
			httpClient.getConnectionManager().shutdown();
		}
		
		return clienteDTO;
	}

}
