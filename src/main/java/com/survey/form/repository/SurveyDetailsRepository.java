package com.survey.form.repository;

import com.survey.form.model.SurveyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyDetailsRepository extends JpaRepository<SurveyDetails, Integer> {

    List<SurveyDetails> findByFirstNameAndLastName(String firstName,String lastName);

    List<SurveyDetails> findByFirstName(String firstName);

    List<SurveyDetails> findByLastName(String lastName);

    Optional<SurveyDetails> findById(Integer id);
}
