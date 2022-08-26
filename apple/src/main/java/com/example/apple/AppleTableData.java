package com.example.apple;

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
public class AppleTableData {

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
    String model;
    Double price;
    Integer quantity;
}
