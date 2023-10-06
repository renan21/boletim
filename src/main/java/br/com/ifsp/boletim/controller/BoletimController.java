package br.com.ifsp.boletim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifsp.boletim.model.NotaModel;
import br.com.ifsp.boletim.service.BoletimService;

@Controller
@RequestMapping
public class BoletimController {
	
	@Autowired
	private BoletimService boletimService;
	
	@GetMapping
	public String carregarPaginaInicial(Model model) {
		return boletimService.carregarPaginaInicial(model);
	}
	
	@GetMapping("nova-nota")
	public String carregarPaginaNovaNota(Model model) {
		return boletimService.carregarPaginaNovaNota(model);
	}
	
	@PostMapping("nova-nota")
	public String registraNota(@Validated NotaModel novaNota) {
		return boletimService.registraNota(novaNota);
	}
		
	@DeleteMapping("excluir-nota/{idNota}")
	public String excluiNota(@PathVariable long idNota) {
		return boletimService.excluiNota(idNota);
	}
	
	
	
	
	
	@PutMapping
	public NotaModel atualizaNota(@RequestBody NotaModel atualizacoesNota) {
		return boletimService.atualizaNota(atualizacoesNota);
	}

}
