package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = {
        "git_http_url",
        "git_ssh_url",
})
public class gitRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Getter @Setter private Long id;

    @Getter @Setter private String name;

    @Column(unique = true)
    @Getter @Setter private String url;

    @Getter @Setter private String description;

    @Getter @Setter private String homepage;

    @JsonProperty("visibility_level")
    @Getter @Setter private int vibilityLevel;
}
