package br.com.personal.webhookreceiver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {
        "id",
        "description",
        "avatar_url",
        "git_ssh_url",
        "git_http_url",
        "namespace",
        "visibility_level",
        "path_with_namespace",
        "default_branch",
        "ci_config_path",
        "homepage",
        "url",
        "ssh_url",
        "http_url"
})
public class Project {

    private String name;

    @JsonProperty("web_url")
    private String webUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
