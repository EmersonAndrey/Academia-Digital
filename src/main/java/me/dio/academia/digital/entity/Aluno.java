package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true)
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	public Aluno(AlunoForm form) {
		this.nome = form.getNome();
		this.cpf = form.getCpf();
		this.bairro = form.getBairro();
		this.dataDeNascimento = form.getDataDeNascimento();
	}
	
	public void updateAluno(AlunoUpdateForm form) {
		this.nome = form.getNome();
		this.bairro = form.getBairro();
		this.dataDeNascimento = form.getDataDeNascimento();
	}

}
