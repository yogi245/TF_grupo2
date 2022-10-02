import { Component, OnInit } from '@angular/core';
import { UsuarioReserva } from '../model/usuario-reserva';
import { UsuarioReservaService } from '../service/usuario-reserva.service';

@Component({
  selector: 'app-usuario-reserva',
  templateUrl: './usuario-reserva.component.html',
  styleUrls: ['./usuario-reserva.component.css']
})
export class UsuarioReservaComponent implements OnInit {
  usuarioReservas : UsuarioReserva;

  constructor(private usuarioReservaService : UsuarioReservaService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    console.log("Reload");
    this.usuarioReservaService.getUsuarioReserva().subscribe(usuarioReservas => this.usuarioReservas = usuarioReservas);
  }
}
