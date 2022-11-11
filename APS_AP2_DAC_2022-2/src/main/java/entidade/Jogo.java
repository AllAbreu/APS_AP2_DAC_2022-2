package entidade;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jogo {

	@Id
	@GeneratedValue
	private Integer id;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "Data_Cadastro")
	private Date dataCadastro = new Date();

	private Integer v1;
	private Integer v2;
	private Integer v3;
	private Integer v4;
	private Integer v5;
	
	private Integer maior;

	public Integer maiorValor() {

		int[] maiorNumero = new int[5];
		maiorNumero[0] = v1;
		maiorNumero[1] = v2;
		maiorNumero[2] = v3;
		maiorNumero[3] = v4;
		maiorNumero[4] = v5;

		for (int i = 0; i < maiorNumero.length - 1; i++) {
			for (int j = i + 1; j < maiorNumero.length; j++) {
				if (maiorNumero[i] > maiorNumero[j]) {
					maior = maiorNumero[i];
				}
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getV1() {
		return v1;
	}

	public void setV1(Integer v1) {
		this.v1 = v1;
	}

	public Integer getV2() {
		return v2;
	}

	public void setV2(Integer v2) {
		this.v2 = v2;
	}

	public Integer getV3() {
		return v3;
	}

	public void setV3(Integer v3) {
		this.v3 = v3;
	}

	public Integer getV4() {
		return v4;
	}

	public void setV4(Integer v4) {
		this.v4 = v4;
	}

	public Integer getV5() {
		return v5;
	}

	public void setV5(Integer v5) {
		this.v5 = v5;
	}

	public Integer getMaior() {
		return maior;
	}

	public void setMaior(Integer maior) {
		this.maior = maior;
	}

}
