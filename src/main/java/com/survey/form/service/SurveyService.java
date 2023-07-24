package com.survey.form.service;

import com.survey.form.dto.SurveyDetailsDto;
import com.survey.form.dto.SurveySearchInput;

import java.util.List;

public interface SurveyService {

    List<SurveyDetailsDto> searchSurveyDetails(SurveySearchInput searchInput);

    SurveyDetailsDto postSurveyDetails(SurveyDetailsDto surveyDetailsDto);

    SurveyDetailsDto updateSurveyDetails(SurveyDetailsDto surveyDetailsDto,int id);

    List<SurveyDetailsDto> getCompleteSurveyDetails();

    void deleteSurveyDetails(int id);
}
