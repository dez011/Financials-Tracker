package com.example.demo.audit;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Immutable
@Table(name="field_group_change")
public class FieldGroupChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_group_id", nullable = false)
    private ChangeTransaction changeTransaction;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_group_id")
    private FieldGroupChange parentChange;

    @Column(name = "entity_type")
    private String entityType;

    @Immutable
    @OneToMany(mappedBy = "parentGroup", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<FieldChange> fieldChanges;
}
