import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UsuarioListaComponent } from './usuario/usuario-lista/usuario-lista.component';
import { UsuarioRegistroComponent } from './usuario/usuario-registro/usuario-registro.component';

const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"usuario_registro", component:UsuarioRegistroComponent},
  {path:"usuario_lista", component:UsuarioListaComponent},
  {path:"login", component:LoginComponent},
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path:'**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
