package com.Riwi.Prueba.Domain.Repository;

import com.Riwi.Prueba.Domain.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
