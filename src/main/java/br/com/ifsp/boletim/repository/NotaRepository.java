package br.com.ifsp.boletim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsp.boletim.model.NotaModel;

public interface NotaRepository extends JpaRepository<NotaModel, Long>  {

}
