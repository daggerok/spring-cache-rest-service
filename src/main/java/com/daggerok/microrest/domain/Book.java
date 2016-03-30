package com.daggerok.microrest.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {
    private static final long serialVersionUID = -1243338676632398744L;

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    String title;

    @NotNull
    String author;
}
