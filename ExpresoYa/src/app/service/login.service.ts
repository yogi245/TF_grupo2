import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  URL_SERVICES='http://localhost:8090';
  private urlBase = this.URL_SERVICES + '/auth';
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json'});

  constructor(private http: HttpClient) { }

  postLogin(login: object) : Observable<object>{
    return this.http.post(this.urlBase + '/login', login, {headers: this.httpHeaders})
                    .pipe(
                      map(response => response as Login[]),
                      catchError(e => {
                        alert(e.status + ":" + e.error.message + " - ")
                        return throwError(() => {
                          const error: any = new Error(e.error.message);
                          error.timestamp = Date.now();
                          return error;
                        });
                      })
                    )
    ;
  }
}
