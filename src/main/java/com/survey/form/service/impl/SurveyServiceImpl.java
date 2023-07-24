package com.survey.form.service.impl;

import com.survey.form.dto.SurveyDetailsDto;
import com.survey.form.dto.SurveySearchInput;
import com.survey.form.exception.DetailsNotFoundException;
import com.survey.form.model.SurveyDetails;
import com.survey.form.repository.SurveyDetailsRepository;
import com.survey.form.service.SurveyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyDetailsRepository surveyDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<SurveyDetailsDto> searchSurveyDetails(SurveySearchInput searchInput) {
        String firstName = searchInput.getFirstName();
        String lastName = searchInput.getLastName();

        List<SurveyDetails> surveyDetails = null;

        if(firstName!=null && lastName!=null) {
            surveyDetails = surveyDetailsRepository.findByFirstNameAndLastName(firstName,lastName);
        } else if (firstName!=null) {
            surveyDetails = surveyDetailsRepository.findByFirstName(firstName);
        } else if (lastName!=null) {
            surveyDetails = surveyDetailsRepository.findByLastName(lastName);
        }
        return Optional.ofNullable(surveyDetails).stream()
                .flatMap(Collection::stream)
                .map(surveyDetails1 -> this.modelMapper.map(surveyDetails1,SurveyDetailsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SurveyDetailsDto postSurveyDetails(SurveyDetailsDto surveyDetailsDto) {
        SurveyDetails surveyDetails = this.modelMapper.map(surveyDetailsDto, SurveyDetails.class);
        return modelMapper.map(surveyDetailsRepository.save(surveyDetails),SurveyDetailsDto.class);
    }

    @Override
    public SurveyDetailsDto updateSurveyDetails(SurveyDetailsDto surveyDetailsDto,int id) {
        return surveyDetailsRepository.findById(id)
                .map(surveyDetails -> {
                    SurveyDetails map = this.modelMapper.map(surveyDetailsDto, SurveyDetails.class);
                    map.setId(id);
                    SurveyDetails save = surveyDetailsRepository.save(map);
                    return this.modelMapper.map(save,SurveyDetailsDto.class);
                }).orElseThrow(()->new DetailsNotFoundException("Details are not present in db for id "+id));
    }

    @Override
    public List<SurveyDetailsDto> getCompleteSurveyDetails() {
        return surveyDetailsRepository.findAll()
                .stream()
                .map(surveyDetails -> this.modelMapper.map(surveyDetails,SurveyDetailsDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteSurveyDetails(int id) {
        SurveyDetails surveyDetails = surveyDetailsRepository.findById(id)
                .orElseThrow(()->new DetailsNotFoundException("SurveyDetails with id "+id+" not found."));
        surveyDetailsRepository.delete(surveyDetails);
    }
}
