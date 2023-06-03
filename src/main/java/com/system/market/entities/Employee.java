package com.system.market.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
@Table (name = "MK_POST")
public class Employee {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private Long cpf;
    @NotBlank
    private  String shift;
    @NotNull
    private Long phone;

    public Employee(EmployeeRequestDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.shift = data.shift();
        this.phone = data.phone();
    }
}
