package com.pitrzuu.api.income;

import com.pitrzuu.api.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
