package com.pitrzuu.api.user;

import com.pitrzuu.api.location.Location;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_hash")
    private String hash;

    @Column(name = "user_salt")
    private String salt;

    @OneToOne(mappedBy = "user", optional = false)
    private Location defaultLocation;

    public Long getId(){
        return id;
    }
    public String getHash(){
        return hash;
    }
    public String getSalt(){
        return salt;
    }
    public Location getDefaultLocation(){
        return defaultLocation;
    }

    public User setHash( String hash ){
        this.hash = hash;
        return this;
    }
    public User setSalt( String salt ){
        this.salt = salt;
        return this;
    }
    public User setDefaultLocation( Location defaultLocation ){
        this.defaultLocation = defaultLocation;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof User user )) return false;
        return getId().equals(user.getId()) && getHash().equals(user.getHash()) && getSalt().equals(user.getSalt()) && getDefaultLocation().equals(user.getDefaultLocation());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getHash(), getSalt(), getDefaultLocation());
    }
}
