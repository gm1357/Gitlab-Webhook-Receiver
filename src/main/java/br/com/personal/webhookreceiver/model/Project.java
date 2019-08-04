package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
    @Getter @Setter private Long id;

    @Getter @Setter private String name;

    @Getter @Setter private String description;

    @JsonProperty("web_url")
    @Getter @Setter private String webUrl;

    @JsonProperty("default_branch")
    @Getter @Setter private String defaultBranch;
}
