package com.Riwi.Prueba.Domain.Entity;

import com.Riwi.Prueba.Utils.Enums.Options;
import com.Riwi.Prueba.Utils.Enums.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String type;
    private String[] opciones1 = {"MENTIRA", "VERDAD"};
    private Options opciones;
    private State state;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    @JsonManagedReference
    private Survey survey;


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<OptionQuestion> questionList;
}
