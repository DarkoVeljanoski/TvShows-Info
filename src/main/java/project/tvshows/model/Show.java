package project.tvshows.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Show {
    @Id
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String name;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String type;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String status;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String language;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String runtime;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String premiered;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String summary;

    public Show() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
