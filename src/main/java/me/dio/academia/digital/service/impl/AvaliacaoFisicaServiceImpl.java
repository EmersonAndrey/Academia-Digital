package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(form);
		avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).get()); 
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoFisicaRepository.findById(id).get();
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
		avaliacaoFisica.updateAvaliacaoFisica(formUpdate);
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}

}
