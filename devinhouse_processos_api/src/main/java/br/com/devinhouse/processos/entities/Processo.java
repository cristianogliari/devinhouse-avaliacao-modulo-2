package br.com.devinhouse.processos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Processo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer nuProcesso;

	@Column
	private String chaveProcesso;
	
	@Column
	private String sgOrgaoProcesso;
	
	@Column
	private String nuAnoProcesso;
	
	@Column
	private String descricao;
	
	@Column
	private Integer cdAssunto;
	
	@Column
	private String descricaoAssunto;
	
	@Column
	private Integer cdInteressado; 
	
	@Column
	private String nmInteressado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNuProcesso() {
		return nuProcesso;
	}
	
	public void setNuProcesso(Integer nuProcesso) {
		this.nuProcesso = nuProcesso;
	}
	
	public String getChaveProcesso() {
		return chaveProcesso;
	}
	
	public void setChaveProcesso(String chaveProcesso) {
		this.chaveProcesso = chaveProcesso;
	}
	
	public String getSgOrgaoProcesso() {
		return sgOrgaoProcesso;
	}
	
	public void setSgOrgaoProcesso(String sgOrgaoProcesso) {
		this.sgOrgaoProcesso = sgOrgaoProcesso;
	}
	
	public String getNuAnoProcesso() {
		return nuAnoProcesso;
	}
	
	public void setNuAnoProcesso(String nuAnoProcesso) {
		this.nuAnoProcesso = nuAnoProcesso;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getCdAssunto() {
		return cdAssunto;
	}
	
	public void setCdAssunto(Integer cdAssunto) {
		this.cdAssunto = cdAssunto;
	}
	
	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}
	
	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}
	
	public Integer getCdInteressado() {
		return cdInteressado;
	}
	
	public void setCdInteressado(Integer cdInteressado) {
		this.cdInteressado = cdInteressado;
	}
	
	public String getNmInteressado() {
		return nmInteressado;
	}
	
	public void setNmInteressado(String nmInteressado) {
		this.nmInteressado = nmInteressado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
