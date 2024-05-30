package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno(form);		
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento) {
		if (dataDeNascimento == null) {
			return repository.findAll();
		}else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}
		
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = repository.findById(id).get();
		aluno.updateAluno(formUpdate);
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
		return repository.findById(id).get().getAvaliacoes();
	}

}
