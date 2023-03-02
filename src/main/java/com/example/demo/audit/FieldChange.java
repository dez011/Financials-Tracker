package com.example.demo.audit;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "field_change")
public class FieldChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_group_id", nullable = false)
    private FieldGroupChange parentGroup;

    @Column(name = "field_uid")
    private String fieldUID;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    protected FieldChange(){}
}
