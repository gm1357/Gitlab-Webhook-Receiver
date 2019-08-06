package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @Id
    private Long id;

    private String name;

    private String description;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("default_branch")
    private String defaultBranch;
}
