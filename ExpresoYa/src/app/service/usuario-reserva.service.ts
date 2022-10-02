import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { UsuarioReserva } from '../model/usuario-reserva';

@Injectable({
  providedIn: 'root'
})
export class UsuarioReservaService {
  URL_SERVICES='http://localhost:8090';
  private urlBase = this.URL_SERVICES + '/api';

  private token = JSON.parse(localStorage.getItem("token") || "");
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json', "Authorization" : "Bearer " + this.token.jwt});

  constructor(private http : HttpClient) {
  }

  getUsuarioReserva() : Observable<any> {
    console.log('Llamando a REST:' + this.urlBase + '/usuario-reservas/2');
    console.log(this.httpHeaders);
    return this.http.get(this.urlBase + '/usuario-reservas/2', {headers: this.httpHeaders})
                    .pipe(map(response => response as UsuarioReserva));
  }
}
