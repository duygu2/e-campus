package com.example.campus.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write"),
    FACULTY_READ("faculty:read"),
    FACULTY_WRITE("faculty:write"),
    INSTITUTE_READ("institute:read"),
    INSTITUTE_WRITE("institute:write"),
    PERSONNEL_WRITE("personnel:write"),
    PERSONNEL_READ("personnel:read"),
    DEPARTMENT_WRITE("department:write"),
    DEPARTMENT_READ("department:read");

    private final String permission;
    ApplicationUserPermission(String permission){
        this.permission=permission;
    }

    public String getPermission(){
        return permission;
    }
}
