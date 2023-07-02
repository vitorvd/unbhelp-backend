package br.com.unbhelp.entities;

import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_feedbacks_professores")
public class FeedbackProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean chamada;

    @Column(nullable = false)
    private boolean trabalho;

    @Column(nullable = false)
    private boolean prova;

    @Column(nullable = false)
    private double avaliacao;

    @Column(nullable = false)
    private String explicacao;

    @ManyToOne
    @JoinColumn(name = "professor", referencedColumnName = "id")
    private Professor professor;

    public static FeedbackProfessor fromDTO(FeedbackProfessorDTO dto){
        FeedbackProfessor feedback = new FeedbackProfessor().builder()
                .id(dto.getId())
                .chamada(dto.isChamada())
                .trabalho(dto.isTrabalho())
                .prova(dto.isProva())
                .avaliacao(dto.getAvaliacao())
                .explicacao(dto.getExplicacao())
                .build();

        return feedback;
    }
}
