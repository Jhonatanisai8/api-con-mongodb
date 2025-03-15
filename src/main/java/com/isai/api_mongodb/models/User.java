package com.isai.api_mongodb.models;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @NonNull
    private Integer userId;

    private String imagePath;
    private String firstName;
    private String lastName;
    private String departamento;
}
