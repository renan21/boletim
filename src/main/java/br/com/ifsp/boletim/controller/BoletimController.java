package br.com.ifsp.boletim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.boletim.model.NotaModel;
import br.com.ifsp.boletim.service.BoletimService;

@RestController
@RequestMapping("boletim/api")
public class BoletimController {
	
	@Autowired
	private BoletimService boletimService;
	
	@GetMapping
	public List<NotaModel> retornaNotas() {
		return boletimService.retornaNotas();
	}
	
	@GetMapping("{idNota}")
	public NotaModel retornaNotaPorId(@PathVariable long idNota) {
		return boletimService.retornaNotaPorId(idNota);
	}
	
	@PostMapping
	public NotaModel registraNota(@RequestBody @Validated NotaModel novaNota) {
		return boletimService.registraNota(novaNota);
	}
	
	@DeleteMapping("{idNota}")
	public String excluiNota(@PathVariable long idNota) {
		boletimService.excluiNota(idNota);
		return "Nota excluída com sucesso.";
	}
	
	@PutMapping
	public NotaModel atualizaNota(@RequestBody NotaModel atualizacoesNota) {
		return boletimService.atualizaNota(atualizacoesNota);
	}

}
