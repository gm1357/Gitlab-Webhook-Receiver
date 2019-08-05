package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @JsonProperty("id")
    private String hash;

    private String message;

    private Timestamp timestamp;

    private String url;

    @ManyToOne
    private Author author;

    @ElementCollection
    private List<String> added = new ArrayList<>();

    @ElementCollection
    private List<String> modified = new ArrayList<>();

    @ElementCollection
    private List<String> removed = new ArrayList<>();
}