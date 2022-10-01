package com.upc.project_os_upc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserva", nullable = false)
    private Long idReserva;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_programacion", referencedColumnName = "id_programacion", nullable = false)
    private Programacion programacion;
    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;
    @Column(name = "cuenta_bancaria", nullable = false, length = 50)
    private String cuentaBancaria;
}
