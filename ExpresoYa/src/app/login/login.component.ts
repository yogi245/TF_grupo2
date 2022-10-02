import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../model/login';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login : Login = new Login();

  constructor(private loginService : LoginService, private router :Router) { }

  ngOnInit(): void {
  }

  iniciarSesion(){
    console.log(this.login);
    this.loginService.postLogin(this.login).subscribe(
      data => {this.router.navigate(['/usuario_reserva']);
              localStorage.setItem("token",JSON.stringify(data));
              }
    );
    const token = JSON.parse(localStorage.getItem("token") || "")
    console.log("Continuando...")
    console.log(token.jwt)
  }

}
