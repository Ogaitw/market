package com.system.market.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
@Table (name = "PT_POST")
public class Product {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Double preco;
    @NotNull
    private Date validade;
    @NotNull
    private Long quantidade;

    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.preco = data.preco();
        this.validade = data.validade();
        this.quantidade = data.quantidade();

    }

}
