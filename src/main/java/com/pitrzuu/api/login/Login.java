package com.pitrzuu.api.login;

import com.pitrzuu.api.user.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "logins")
public class Login {
    public Login(){}
    public Login(User user, String location, String ip) {
        this.user = user;
        this.location = location;
        this.ip = ip;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer id() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public User user() {
        return user;
    }
    public Login setUser(User user) {
        this.user = user;
        return this;
    }

    @CreatedDate
    @Column(name = "login_date", nullable = false)
    private Date date;
    public Date date() {
        return date;
    }

    @Column(name = "login_location")
    private String location;
    public String location() {
        return location;
    }
    public Login setLocation(String location) {
        this.location = location;
        return this;
    }

    @Column(name = "login_ip")
    private String ip;
    public String ip() {
        return ip;
    }
    public Login setIp(String ip) {
        this.ip = ip;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login login)) return false;
        return id.equals(login.id) && user.equals(login.user) && date.equals(login.date) && Objects.equals(location, login.location) && Objects.equals(ip, login.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, date, location, ip);
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
