package com.Riwi.Prueba.Domain.Repository;
import com.Riwi.Prueba.Domain.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
}
