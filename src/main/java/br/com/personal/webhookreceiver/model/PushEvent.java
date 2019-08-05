package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(value = {
        "object_kind",
        "event_name",
        "before",
        "after",
        "ref",
        "message",
        "user_id",
        "user_avatar",
        "project_id",
        "push_options"
})
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
