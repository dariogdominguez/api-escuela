package ar.com.dario.colmena.api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grade extends Base {
    @Column(unique = true)
    private String name;
    private String classCode;

    @ManyToMany
    @JoinTable(name="grade_professor",
        joinColumns=
            @JoinColumn(name="grade_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="professor_id", referencedColumnName="id")
        )
    private Set<Professor> professors;

    @ManyToMany
    @JoinTable(name="grade_student",
        joinColumns=
            @JoinColumn(name="grade_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="student_id", referencedColumnName="id")
        )
    private Set<Student> students;

    public void addProfessor(Professor professor) {
        if (professors == null) {
            professors = new HashSet<>();
        }
        professors.add(professor);
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new HashSet<>();
        }
        students.add(student);
    }
}

