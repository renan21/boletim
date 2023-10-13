package br.com.ifsp.boletim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	public String carregarPaginaNovaNota() {
		return "nova-nota";
	}
	
	public String carregarPaginaEditarNota(long idNota, Model model) {
		Optional<NotaModel> nota = notaRepository.findById(idNota);		
		if(nota.isPresent()) {
			model.addAttribute("nota", nota.get());
			return "editar-nota";
		}
		return "redirect:/notas";
	}
	
	public String excluiNota(long idNota) {
		Optional<NotaModel> nota = notaRepository.findById(idNota);
		if(nota.isPresent()) {
			notaRepository.deleteById(idNota);
			return "redirect:/notas";
		}
		return "redirect:/notas";
	}
		
	public String registraNota(NotaModel novaNota, BindingResult result, RedirectAttributes attributes) {		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", result.getAllErrors().get(0).getDefaultMessage());
			return "redirect:/notas";
		}
		notaRepository.save(novaNota);		
		return "redirect:/notas";
	}
		
	public String atualizaNota(long idNota, NotaModel atualizacoesNota, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", result.getAllErrors().get(0).getDefaultMessage());
			return "redirect:/notas";
		}
		Optional<NotaModel> nota = notaRepository.findById(idNota);		
		if(nota.isPresent()) {
			nota.get().setMateria(atualizacoesNota.getMateria());
			nota.get().setNota(atualizacoesNota.getNota());
			notaRepository.save(nota.get());
		}	
		return "redirect:/notas";
	}




	

	
	

}
