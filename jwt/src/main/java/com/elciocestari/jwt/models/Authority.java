package com.elciocestari.jwt.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "user_id")
    private Long id;

    @Column(name = "authority_name", length = 50, unique = true)
    private String authorityName;
}
