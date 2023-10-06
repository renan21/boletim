package br.com.ifsp.boletim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsp.boletim.model.NotaModel;
import br.com.ifsp.boletim.repository.NotaRepository;

@Service
public class BoletimRestService {
	
	@Autowired
	private NotaRepository notaRepository;

	public List<NotaModel> retornaNotas() {
		return notaRepository.findAll();
	}

	public NotaModel retornaNotaPorId(long idNota) {
		return notaRepository.findById(idNota).orElse(new NotaModel());
	}

	public NotaModel registraNota(NotaModel novaNota) {
		return notaRepository.save(novaNota);
	}

	public void excluiNota(long idNota) {
		notaRepository.deleteById(idNota);		
	}

	public NotaModel atualizaNota(NotaModel atualizacoesNota) {
		
		NotaModel nota = notaRepository.findById(atualizacoesNota.getIdNota()).get();		
		if(nota == null) {
			return new NotaModel();
		}
		
		nota.setMateria(atualizacoesNota.getMateria());
		nota.setNota(atualizacoesNota.getNota());
		
		return notaRepository.save(nota);
	}
	

	
	

}
