package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("user_name")
    private String userFullName;

    @JsonProperty("user_username")
    private String userName;

    @JsonProperty("user_email")
    private String userEmail;

    @ManyToOne
    private Project project;

    @OneToMany
    private List<Commit> commits;

    @JsonProperty("checkout_sha")
    private String checkouSha;

    @JsonProperty("total_commits_count")
    private Integer totalCommits;

    @ManyToOne
    private gitRepository repository;
}
