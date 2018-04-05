package com.netTutor.application.domain.enums;

//   public enum Role_Enum{SUPER_ADMIN(1), ADMIN, MANAGER, TEACHER, STUDENT};
public enum Role_Enum {
    SUPER_ADMIN("SuperAdmin", 1),
    ADMIN("Admin", 2),
    MANAGER("Manager", 3),
    TEACHER("Teacher", 4),
    STUDENT("Student",5);

    private final java.lang.String key;
    private final Integer value;

    Role_Enum(java.lang.String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public java.lang.String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
};



