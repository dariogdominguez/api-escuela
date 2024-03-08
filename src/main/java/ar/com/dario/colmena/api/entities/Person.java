package ar.com.dario.colmena.api.entities;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person extends Base {
    String name;
    @NonNull
    String email;
    @NonNull
    String password;
    String dni;
    int age;
    String adress;
}
