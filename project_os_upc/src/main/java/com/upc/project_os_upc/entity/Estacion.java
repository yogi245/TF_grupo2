package com.upc.project_os_upc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "estacion")
public class Estacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estacion", nullable = false)
    private Long idEstacion;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_tipo_servicio", referencedColumnName = "id_tipo_servicio", nullable = false)
    private TipoServicio tipoServicio;
}
