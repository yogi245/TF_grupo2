package com.upc.project_os_upc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tipo_servicio")
public class TipoServicio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_servicio", nullable = false)
    private Long idTipoServicio;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "tarifa", nullable = false, precision = 2)
    private double tarifa;
}
