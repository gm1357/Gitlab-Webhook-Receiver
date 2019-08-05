package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(value = {
        "avatar_url",
        "git_ssh_url",
        "git_http_url",
        "namespace",
        "visibility_level",
        "path_with_namespace",
        "ci_config_path",
        "homepage",
        "url",
        "ssh_url",
        "http_url"
})
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
