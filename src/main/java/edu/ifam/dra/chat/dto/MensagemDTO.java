package edu.ifam.dra.chat.dto;

import java.util.Calendar;

public class MensagemDTO {
	private Calendar dataHora;
	private String conteudo;
	private Long emissor;
	private Long receptor;
	
	public MensagemDTO(String conteudo, Long emissor, Long receptor) {
		super();
		this.dataHora = Calendar.getInstance();
		this.conteudo = conteudo;
		this.emissor = emissor;
		this.receptor = receptor;
	}
	
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Long getEmissor() {
		return emissor;
	}
	public void setEmissor(Long emissor) {
		this.emissor = emissor;
	}
	public Long getReceptor() {
		return receptor;
	}
	public void setReceptor(Long receptor) {
		this.receptor = receptor;
	}
}
