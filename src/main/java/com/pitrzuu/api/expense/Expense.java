package com.pitrzuu.api.expense;

import com.pitrzuu.api.expense.item.Item;
import com.pitrzuu.api.user.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Integer id;

    @Column(name = "expense_amount")
    private Integer amount;

    @Column(name = "expense_total")
    private Float total;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "loans")
    private Set<User> loaners = new HashSet<>();

    @OneToMany(mappedBy = "expense")
    private Set<Item> items = new HashSet<>();
}
