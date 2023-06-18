package br.com.unbhelp.entities;

import dtos.FeedbackDisciplinaProfessorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_feedback_disciplina_professor")
public class FeedbackDisciplinaProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "codigo")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "professor", referencedColumnName = "nome")
    private Professor professor;

    public static FeedbackDisciplinaProfessor fromDTO(FeedbackDisciplinaProfessorDTO dto){
        FeedbackDisciplinaProfessor feedback = new FeedbackDisciplinaProfessor().builder()
                .id(dto.getId())
                .texto(dto.getTexto())
                .build();
        return feedback;
    }
}
