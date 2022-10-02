import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UsuarioRegistroComponent } from './usuario/usuario-registro/usuario-registro.component';
import { UsuarioListaComponent } from './usuario/usuario-lista/usuario-lista.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { UsuarioReservaComponent } from './usuario-reserva/usuario-reserva.component';
import { ReservaComponent } from './reserva/reserva.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent,
    UsuarioRegistroComponent,
    UsuarioListaComponent,
    LoginComponent,
    UsuarioReservaComponent,
    ReservaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
