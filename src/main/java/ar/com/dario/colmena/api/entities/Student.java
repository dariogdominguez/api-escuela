package ar.com.dario.colmena.api.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student extends Person {
        private Boolean hasPc;
        private String pcDescription;
        
        @JsonIgnore
        @ManyToMany(mappedBy = "students")
        private Set<Grade> grades;
}
