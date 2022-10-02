import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuario-registro',
  templateUrl: './usuario-registro.component.html',
  styleUrls: ['./usuario-registro.component.css']
})
export class UsuarioRegistroComponent implements OnInit {
  usuario : Usuario = new Usuario();

  constructor(private usuarioService : UsuarioService, private router : Router) {
  }

  ngOnInit(): void {
  }

  grabar(){
    console.log(this.usuario);
    this.usuarioService.postUsuarioRegistro(this.usuario).subscribe(
      data => this.router.navigate(['/usuario_lista'])
    );
    console.log("continuando...")
  }

}
