package com.kevvvvyp.github.sdrsample.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "child_1")
public class Child1 {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "child_1_value")
    private String child1Value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private Parent parent;
}