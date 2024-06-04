package com.Riwi.Prueba.Domain.Entity;

import com.Riwi.Prueba.Utils.Enums.NoticeState;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity(name = "optionquestion")
public class OptionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private NoticeState noticeState;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference
    private Question question;
}
