package br.com.ifsp.boletim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.ifsp.boletim.model.NotaModel;
import br.com.ifsp.boletim.repository.NotaRepository;

@Service
public class BoletimService {
	
	@Autowired
	private NotaRepository notaRepository;
	
	public String carregarPaginaInicial(Model model) {
	       List<NotaModel> notas = notaRepository.findAll();
	        model.addAttribute("notas", notas);
	        
	        
	        int somaTotal = 0;
	        for(NotaModel nota : notas) {
	        	somaTotal += nota.getNota();
	        }
	        
	        double media = 0;
	        if(notas.size() != 0) {
	        	media = somaTotal / notas.size();
	        }
	        model.addAttribute("media", media);
	        	        
			return "notas";
	}
	
	public String carregarPaginaNovaNota(Model model) {
		return "nova-nota";
	}
		
	public String registraNota(NotaModel novaNota) {		
		if(novaNota.getMateria().equals("")) {
			return "redirect:/";
		}
		notaRepository.save(novaNota);		
		return "redirect:/";
	}
	
	public String excluiNota(long idNota) {
		Optional<NotaModel> nota = notaRepository.findById(idNota);
		if(nota.isPresent()) {
			notaRepository.deleteById(idNota);
			return "notas";
		}
		return "notas";
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
