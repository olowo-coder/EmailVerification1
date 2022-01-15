package com.example.emailfirstverification.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken {

    @Id
    private int id;

    private String token;

    private Timestamp expiryDate;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    public VerificationToken(Users user, String token) {
        this.token = token;
        this.user = user;
    }
}
