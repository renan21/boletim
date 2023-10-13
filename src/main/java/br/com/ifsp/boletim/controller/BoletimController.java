package br.com.ifsp.boletim.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ifsp.boletim.model.NotaModel;
import br.com.ifsp.boletim.service.BoletimService;

@Controller
@RequestMapping("notas")
public class BoletimController {
	
	@Autowired
	private BoletimService boletimService;
	
	@GetMapping
	public String carregarPaginaInicial(Model model) {
		return boletimService.carregarPaginaInicial(model);
	}
	
	@GetMapping("nova-nota")
	public String carregarPaginaNovaNota() {
		return boletimService.carregarPaginaNovaNota();
	}
	
	@GetMapping("editar-nota/{idNota}")
	public String carregarPaginaEditarNota(@PathVariable long idNota, Model model) {
		return boletimService.carregarPaginaEditarNota(idNota, model);
	}
	
	@GetMapping("excluir-nota/{idNota}")
	public String excluiNota(@PathVariable long idNota) {
		return boletimService.excluiNota(idNota);
	}
	
	@PostMapping("nova-nota")
	public String registraNota(@Valid NotaModel novaNota, BindingResult result, RedirectAttributes attributes) {
		return boletimService.registraNota(novaNota, result, attributes);
	}
			
	@PostMapping("editar-nota/{idNota}")
	public String atualizaNota(@PathVariable long idNota, @Valid NotaModel atualizacoesNota, BindingResult result, RedirectAttributes attributes) {
		return boletimService.atualizaNota(idNota, atualizacoesNota, result, attributes);
	}

}
