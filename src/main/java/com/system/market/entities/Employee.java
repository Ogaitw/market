package com.system.market.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table (name = "MK_POST")
public class Employee {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
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


}
