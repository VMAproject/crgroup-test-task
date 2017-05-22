package com.crgroup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends BaseModel {

    private String name;
    private String comment;
    private String department;
    @ManyToOne
    private Superior superior;

    public Employee() {
    }

    public Employee(String name, String comment, String department) {
        super();
        this.name = name;
        this.comment = comment;
        this.department = department;
    }

    public Employee(String name, String comment, String department, Superior superior) {
        super();
        this.name = name;
        this.comment = comment;
        this.department = department;
        this.superior = superior;
    }

    @Override
    public String toString() {
        return " {\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"comment\":\"" + comment
                + "\",\"unitPrice\":\"" + "\",\"department\":\"" + department + "\",\"superior\":\""
                + superior + "\"}";
    }
}
