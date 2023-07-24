package com.survey.form.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "survey_details")
public class SurveyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "zip")
    private String zip;

    @Column(name = "telephone_no")
    private String telephoneNo;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_survey")
    private LocalDateTime dateOfSurvey;

    @Column(name = "most_liked")
    private String mostLiked;

    @Column(name = "resource")
    private String resource;

    @Column(name = "recommendation")
    private String recommendation;

}
