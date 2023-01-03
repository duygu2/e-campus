package com.example.campus.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Provider;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.campus.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ)),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    HR(Sets.newHashSet(PERSONNEL_WRITE,PERSONNEL_READ)),
    INSTITUTE(Sets.newHashSet(INSTITUTE_WRITE,INSTITUTE_READ)),
    FACULTY(Sets.newHashSet(FACULTY_WRITE,FACULTY_READ)),
    DEPARTMENT(Sets.newHashSet(COURSE_WRITE,COURSE_READ,DEPARTMENT_READ,DEPARTMENT_WRITE)),
    TEACHER(Sets.newHashSet(COURSE_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions =permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions =getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}
