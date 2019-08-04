package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(value = {
        "added",
        "modified",
        "removed"
})
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Getter @Setter private Long id;

    @JsonProperty("id")
    @Getter @Setter private String hash;

    @Getter @Setter private String message;

    @Getter @Setter private Timestamp timestamp;

    @Getter @Setter private String url;

    @ManyToOne
    @Getter @Setter private Author author;
}