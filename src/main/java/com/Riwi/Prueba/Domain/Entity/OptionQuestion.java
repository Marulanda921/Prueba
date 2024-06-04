package com.Riwi.Prueba.Domain.Entity;

import com.Riwi.Prueba.Utils.Enums.State;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "optionquestion")
public class OptionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private State state;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference
    private Question question;
}
