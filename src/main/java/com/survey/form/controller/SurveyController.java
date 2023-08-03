package com.survey.form.controller;

import com.survey.form.dto.SurveyDetailsDto;
import com.survey.form.dto.SurveySearchInput;
import com.survey.form.service.SurveyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping("/details")
    public List<SurveyDetailsDto> serachDetails(
            @RequestParam(name = "firstName",required = false) String firstName,
            @RequestParam(name = "lastName",required = false) String lastName
    ) {
        SurveySearchInput searchInput = SurveySearchInput
                .builder().firstName(firstName).lastName(lastName)
                .build();
        return surveyService.searchSurveyDetails(searchInput);
    }

    @GetMapping("/details/all")
    public List<SurveyDetailsDto> completeDetails() {
        return surveyService.getCompleteSurveyDetails();
    }

    @PostMapping("/details")
    public SurveyDetailsDto postDetails(@RequestBody @Valid SurveyDetailsDto surveyDetailsDto) {
        return surveyService.postSurveyDetails(surveyDetailsDto);
    }

    @PutMapping("/details/{id}")
    public SurveyDetailsDto updateDetails(@RequestBody @Valid SurveyDetailsDto surveyDetailsDto, @PathVariable("id") int id) {
        return surveyService.updateSurveyDetails(surveyDetailsDto,id);
    }

    @DeleteMapping("/details/{id}")
    public void deleteSurveyDetails(@PathVariable("id") int id) {
        surveyService.deleteSurveyDetails(id);
    }
}
