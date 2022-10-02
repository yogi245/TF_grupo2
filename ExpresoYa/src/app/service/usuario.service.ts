import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  URL_SERVICES='http://localhost:8091';
  private urlBase = this.URL_SERVICES + '/api';
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json'});
  constructor(private http: HttpClient) { }

  getUsuarioLista() : Observable<any> {
    console.log('Llamando a REST:' + this.urlBase + '/usuario');
    return this.http.get(this.urlBase + '/usuario').pipe(map(response => response as Usuario[]));
  }

  postUsuarioRegistro(usuario: object) : Observable<object>{
    return this.http.post(this.urlBase + '/usuario', usuario, {headers: this.httpHeaders});
  }
}
