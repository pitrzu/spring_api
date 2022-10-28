package com.pitrzuu.api.expense.item;

import com.pitrzuu.api.expense.Expense;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;
}
