package br.com.unbhelp.entities;

import dtos.FeedbackDisciplinaDTO;
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
@Table(name = "tb_feedbacksDisciplinas")
public class FeedbackDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "disciplina_codigo", referencedColumnName = "codigo")
    private Disciplina disciplina;

    public static FeedbackDisciplina fromDTO(FeedbackDisciplinaDTO dto){
        FeedbackDisciplina feedback = new FeedbackDisciplina().builder()
                .id(dto.getId())
                .texto(dto.getTexto())
                .build();
        return feedback;
    }

}
