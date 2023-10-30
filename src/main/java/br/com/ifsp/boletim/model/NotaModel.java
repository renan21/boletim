package br.com.ifsp.boletim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nota")
public class NotaModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNota;
	
	@NotEmpty(message = "Matéria não pode estar vazia.")
	private String materia;
	
    @Min(value = 0, message="Nota deve ser maior ou igual 0.")
    @Max(value = 10, message="Nota deve ser menor ou igual 10.")
    @NotNull(message = "Nota não pode estar vazia.")
	private int nota;

}
