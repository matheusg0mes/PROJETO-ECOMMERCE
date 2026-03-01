package br.com.projeto.ecommerce.security;

public class ECToken {

	private String token;

	
	public ECToken() {
		super();
	
	}

	public ECToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
