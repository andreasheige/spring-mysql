package com.toto.todo.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "todos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true) 
// This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values
public class Todo implements Serializable{
    @Id // Declare Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Defines Primary Key
    private Long id;

    @NotBlank // Can not be null
    private String title;

    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)
    // Define the properties of the column that will be mapped to the annotated field
    @Temporal(TemporalType.TIMESTAMP)
    // Converts the date and time values from Java Object to compatible database type and vice versa
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}