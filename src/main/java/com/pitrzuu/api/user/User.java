package com.pitrzuu.api.user;

import com.pitrzuu.api.expense.Expense;
import com.pitrzuu.api.income.Income;
import com.pitrzuu.api.login.Login;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    public User() {}
    public User(String name, String email, String hash) {
        this.name = name;
        this.email = email;
        this.hash = hash;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @Column(name = "user_name", nullable = false)
    private String name;
    public String getName() {
        return name;
    }
    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "user_email", nullable = false)
    private String email;
    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "user_hash", nullable = false)
    private String hash;
    public String getHash() {
        return hash;
    }
    public User setHash(String hash) {
        this.hash = hash;
        return this;
    }

    @CreatedDate
    @Column(name = "user_creation_date")
    private Date creationDate;
    public Date getCreationDate() {
        return creationDate;
    }

    @LastModifiedDate
    @Column(name = "user_update_date")
    private Date updateDate;
    public Date getUpdateDate() { return updateDate; }

    @OneToMany(mappedBy = "user")
    private Set<Expense> expenses = new HashSet<>();
    public Set<Expense> getExpenses() {
        return expenses;
    }
    public User setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
        return this;
    }

    @ManyToMany
    @JoinTable(
            name = "loans",
            joinColumns = { @JoinColumn(name = "expense_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<Expense> loans = new HashSet<>();
    public Set<Expense> getLoans() {
        return loans;
    }
    public User setLoans(Set<Expense> loans) {
        this.loans = loans;
        return this;
    }

    @OneToMany(mappedBy = "user")
    private Set<Income> incomes = new HashSet<>();
    public Set<Income> getIncomes() {
        return incomes;
    }
    public User setIncomes(Set<Income> incomes) {
        this.incomes = incomes;
        return this;
    }

    @OneToMany(mappedBy = "user")
    private Set<Login> logins = new HashSet<>();
    public Set<Login> getLogins() {
        return logins;
    }
    public User setLogins(Set<Login> logins) {
        this.logins = logins;
        return this;
    }

    @ManyToMany
    @JoinTable(
            name = "friends",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "friend_id") }
    )
    private Set<User> myFriends = new HashSet<>();
    public Set<User> getMyFriends() {
        return myFriends;
    }
    public User setMyFriends(Set<User> myFriends) {
        this.myFriends = myFriends;
        return this;
    }

    @ManyToMany(mappedBy = "myFriends")
    private Set<User> friendsWith = new HashSet<>();
    public Set<User> getFriendsWith() {
        return friendsWith;
    }
    public User setFriendsWith(Set<User> friendsWith) {
        this.friendsWith = friendsWith;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id.equals(user.id) && name.equals(user.name) && email.equals(user.email) && hash.equals(user.hash) && creationDate.equals(user.creationDate) && Objects.equals(updateDate, user.updateDate) && Objects.equals(expenses, user.expenses) && Objects.equals(loans, user.loans) && Objects.equals(incomes, user.incomes) && Objects.equals(logins, user.logins) && Objects.equals(myFriends, user.myFriends) && Objects.equals(friendsWith, user.friendsWith);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, hash, creationDate, updateDate, expenses, loans, incomes, logins, myFriends, friendsWith);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hash='" + hash + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", expenses=" + expenses +
                ", loans=" + loans +
                ", incomes=" + incomes +
                ", logins=" + logins +
                ", myFriends=" + myFriends +
                ", friendsWith=" + friendsWith +
                '}';
    }
}