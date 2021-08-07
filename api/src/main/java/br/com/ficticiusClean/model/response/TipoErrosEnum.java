package br.com.ficticiusClean.model.response;

public enum TipoErrosEnum {

	required("required"),
	invalid("invalid"),
	system("system");

	private final String valor;

	TipoErrosEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

	@Override
	public String toString() {
		return this.getValor();
	}
}
