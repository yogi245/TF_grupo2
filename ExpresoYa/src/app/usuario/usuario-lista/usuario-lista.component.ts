import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-lista',
  templateUrl: './usuario-lista.component.html',
  styleUrls: ['./usuario-lista.component.css']
})
export class UsuarioListaComponent implements OnInit {
  usuarios : Usuario[];

  constructor(private usuarioService : UsuarioService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    console.log("Reload");
    this.usuarioService.getUsuarioLista().subscribe(usuarios => this.usuarios = usuarios);
  }

}
