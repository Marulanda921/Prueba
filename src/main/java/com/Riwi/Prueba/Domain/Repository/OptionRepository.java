package com.Riwi.Prueba.Domain.Repository;

import com.Riwi.Prueba.Domain.Entity.OptionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<OptionQuestion, Integer> {
}
