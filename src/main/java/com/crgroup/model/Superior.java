package com.crgroup.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "superior")
public class Superior extends BaseModel {

    private String name;
    private String department;
    private String comment;

    @JsonIgnore
    @OneToMany(mappedBy = "superior", targetEntity = Employee.class, fetch = FetchType.EAGER)
    private Collection<Employee> employees;

    public Superior() {
    }

    public Superior(String name, String department, String comment, Collection<Employee> employees) {
        super();
        this.name = name;
        this.department = department;
        this.comment = comment;
        this.employees = employees;
    }

    public Superior(String name, String department, String comment) {
        super();
        this.name = name;
        this.department = department;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return " {\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"comment\":\"" + comment + "\",\"department\":\"" + department + "\"}";
    }
}
