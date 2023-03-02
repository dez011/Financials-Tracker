package com.example.demo.audit;

public interface Auditable {
    String entityType();
    FieldGroupChange getChangeGroup();
    boolean shouldLog();
}
