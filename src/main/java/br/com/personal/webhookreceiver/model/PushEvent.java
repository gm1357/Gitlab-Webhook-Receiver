package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
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
    @Getter @Setter private Long id;

    @JsonProperty("user_name")
    @Getter @Setter private String userFullName;

    @JsonProperty("user_username")
    @Getter @Setter private String userName;

    @JsonProperty("user_email")
    @Getter @Setter private String userEmail;

    @ManyToOne
    @Getter @Setter private Project project;

    @OneToMany
    @Getter @Setter private List<Commit> commits;

    @JsonProperty("checkout_sha")
    @Getter @Setter private String checkouSha;

    @JsonProperty("total_commits_count")
    @Getter @Setter private Integer totalCommits;

    @ManyToOne
    @Getter @Setter private gitRepository repository;
}
