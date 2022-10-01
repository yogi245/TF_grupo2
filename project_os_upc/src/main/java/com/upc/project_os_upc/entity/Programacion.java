package com.upc.project_os_upc.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programacion")
public class Programacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_programacion", nullable = false)
    private Long idProgramacion;
    @ManyToOne
    @JoinColumn(name = "id_estacion", referencedColumnName = "id_estacion", nullable = false)
    private Estacion estacion;
    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario", nullable = false)
    private Horario horario;
    @ManyToOne
    @JoinColumn(name = "id_destino", referencedColumnName = "id_destino", nullable = false)
    private Destino destino;
    @Column(name = "activa", columnDefinition = "boolean default true", nullable = false)
    private Boolean activa;
}
