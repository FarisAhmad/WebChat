package br.com.ltp4.enums;

public enum MensagemBancoEnum {
	OK("1"),
	PK_EXISTENTE("0"),
	Error("-1");
	
	private String codigo;
	
	MensagemBancoEnum(String codigo) {
		this.setCodigo(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
