package com.upc.project_os_upc.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@ToString
@Entity
@Table(name = "horario")
public class Horario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_horario", nullable = false)
    private Long idHorario;
    @Column(name = "hora", nullable = false)
    private Time hora;
}
