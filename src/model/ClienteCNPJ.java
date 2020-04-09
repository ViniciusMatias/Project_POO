package model;

public class ClienteCNPJ extends Cliente {

	private String CNPJ;

	public ClienteCNPJ(String nome, String endereco, String email, String Cnpj) {
		super(nome, endereco, email);
		this.CNPJ = Cnpj;
	}

	@Override
	public String getId() {
		return this.CNPJ;
	}

	public void setCNPJ(String cnpj) {
		this.CNPJ = cnpj;
	}

}
