package com.blogapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    private List<Entry> entries;

    @OneToMany(mappedBy = "user")
    private List<Reply> replies;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(Integer id, String username, String password, String email, Date birthDate, List<Like> listOfLikeFromListOfLikeDTO) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.likes = likes;
    }

    public User(int i, String farid, String farid1, String mail) {
        this.id = i;
        this.username = farid;
        this.password = farid1;
        this.email = mail;
    }
}
