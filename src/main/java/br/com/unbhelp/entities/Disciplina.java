package br.com.unbhelp.entities;

import br.com.unbhelp.dtos.DisciplinaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_disciplinas")
public class Disciplina {

    @Id
    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String ementa;

    @Column(nullable = false)
    private Double avaliacao;

    public static Disciplina fromDTO(DisciplinaDTO dto){
        Disciplina disciplina = new Disciplina().builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .ementa(dto.getEmenta())
                .avaliacao(dto.getAvaliacao())
                .build();

        return disciplina;
    }

}
