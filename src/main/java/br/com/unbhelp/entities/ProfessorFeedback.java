package br.com.unbhelp.entities;

import dtos.ProfessorFeedbackDTO;
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
@Table(name="tb_feedbacks")
public class ProfessorFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;




    public static ProfessorFeedback fromDTO(ProfessorFeedbackDTO dto){
        ProfessorFeedback feedback = new ProfessorFeedback().builder()
                .id(dto.getId())
                .text(dto.getText())
                .professor(Professor.builder().id(dto.getId()).build())
                .build();

        return feedback;
    }
}
