package com.upc.project_os_upc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "servicio")
public class Servicio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_servicio", nullable = false)
    private Long idServicio;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_tipo_servicio", referencedColumnName = "id_tipo_servicio", nullable = false)
    private TipoServicio tipoServicio;
}
