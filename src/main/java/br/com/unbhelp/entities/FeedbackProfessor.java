package br.com.unbhelp.entities;

import dtos.FeedbackProfessorDTO;
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
@Table(name="tb_feedbacksProfessores")
public class FeedbackProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "professor_nome", referencedColumnName = "nome")
    private Professor professor;




    public static FeedbackProfessor fromDTO(FeedbackProfessorDTO dto){
        FeedbackProfessor feedback = new FeedbackProfessor().builder()
                .id(dto.getId())
                .text(dto.getText())
                .build();

        return feedback;
    }
}
