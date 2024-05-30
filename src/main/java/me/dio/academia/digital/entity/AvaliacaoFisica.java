package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

	@Column(name = "peso_atual")
	private double peso;

	@Column(name = "altura_atual")
	private double altura;

	
	public AvaliacaoFisica(AvaliacaoFisicaForm form) {
		this.peso = form.getPeso();
		this.altura = form.getAltura();
	}
	
	public void updateAvaliacaoFisica(AvaliacaoFisicaUpdateForm form) {
		this.peso = form.getPeso();
		this.altura = form.getAltura();
	}
}
