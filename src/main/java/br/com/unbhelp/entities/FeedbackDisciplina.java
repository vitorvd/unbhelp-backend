package br.com.unbhelp.entities;

import br.com.unbhelp.dtos.FeedbackDisciplinaDTO;
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
    private Disciplina codigo;

    public static FeedbackDisciplina fromDTO(FeedbackDisciplinaDTO dto){
        FeedbackDisciplina feedback = new FeedbackDisciplina().builder()
                .id(dto.getId())
                .texto(dto.getTexto())
                .codigo(Disciplina.fromDTO(dto.getDisciplinaDTO()))
                .build();
        return feedback;
    }

}
