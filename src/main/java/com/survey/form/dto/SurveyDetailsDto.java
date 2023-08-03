package com.survey.form.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDetailsDto {

    @NotEmpty(message = "cannot be empty/null")
    private String firstName;

    @NotEmpty(message = "cannot be empty/null")
    private String lastName;

    @NotEmpty(message = "cannot be empty/null")
    private String streetAddress;

    @NotEmpty(message = "cannot be empty/null")
    private String city;

    @NotEmpty(message = "cannot be empty/null")
    private String state;

    @NotEmpty(message = "cannot be empty/null")
    private String zip;

    @NotEmpty(message = "cannot be empty/null")
    private String telephoneNo;

    @NotEmpty(message = "cannot be empty/null")
    private String email;

    @NotEmpty(message = "cannot be empty/null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateOfSurvey;

    private String mostLiked;

    private String resource;

    private String recommendation;
}
