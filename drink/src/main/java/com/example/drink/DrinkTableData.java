package com.example.drink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DrinkTableData {

    @SequenceGenerator(
            name = "manager_id_sequence",
            sequenceName = "manager_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "manager_id_sequence"
    )
    @Id
    Integer id;
    String kind;
    Double price;
    Integer quantity;
}
