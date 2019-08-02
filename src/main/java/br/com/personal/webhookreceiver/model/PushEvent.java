package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(value = {
        "object_kind",
        "event_name",
        "before",
        "after",
        "ref",
        "checkout_sha",
        "message",
        "user_id",
        "user_username",
        "user_email",
        "user_avatar",
        "project_id",
        "total_commits_count",
        "push_options",
        "repository"
})
public class PushEvent {

    @JsonProperty("user_name")
    private String userName;
    private Project project;

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    private List<Commit> commits;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
