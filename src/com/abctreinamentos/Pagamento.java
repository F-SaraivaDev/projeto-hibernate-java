package com.abctreinamentos;

// Generated Jan 24, 2017 8:17:50 PM by Hibernate Tools 4.3.1

/**
 * Pagamento generated by hbm2java
 */
public class Pagamento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PagamentoId id;
	private String datainscricao;

	public Pagamento() {
	}

	public Pagamento(PagamentoId id, String datainscricao) {
		this.id = id;
		this.datainscricao = datainscricao;
	}

	public PagamentoId getId() {
		return this.id;
	}

	public void setId(PagamentoId id) {
		this.id = id;
	}

	public String getDatainscricao() {
		return this.datainscricao;
	}

	public void setDatainscricao(String datainscricao) {
		this.datainscricao = datainscricao;
	}
	
	@Override
	public String toString() {		
		return "\nPAGAMENTO\nCPF: " + id.getCpf() 
                + "\nCDCURSO: " + id.getCdcurso()
                + "\nDATA INSCRI��O: " + datainscricao;
	}

}