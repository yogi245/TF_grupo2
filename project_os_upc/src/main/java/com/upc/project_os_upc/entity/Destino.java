package com.upc.project_os_upc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "destino")
public class Destino {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_destino", nullable = false)
    private Long idDestino;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
}
