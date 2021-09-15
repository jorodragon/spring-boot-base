package com.jorodragon.springbootbase.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User extends BaseEntity{
    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="phone", length = 11)
    private String phone;

    @Column(name="avatar")
    private String avatar;

    public void setPassword(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.password = hash;
    }
}
