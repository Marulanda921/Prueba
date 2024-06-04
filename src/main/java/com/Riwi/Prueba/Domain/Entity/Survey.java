package com.Riwi.Prueba.Domain.Entity;


import com.Riwi.Prueba.Utils.Enums.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(min = 0, max = 11)
    private int id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @JsonManagedReference
    private User user;

/*
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<User> users = new ArrayList<>();

*/
@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonBackReference
private List<Question> questions = new ArrayList<>();


}

