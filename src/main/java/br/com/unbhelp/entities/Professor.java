package br.com.unbhelp.entities;


import dtos.ProfessorDTO;
import dtos.UsuarioDTO;
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
@Table(name = "tb_professores")
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double avaliacao;

    public static Professor fromDTO(ProfessorDTO dto){
        Professor professor = new Professor().builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .nome(dto.getNome())
                .avaliacao(dto.getAvaliacao())
                .build();

        return professor;
    }

}
