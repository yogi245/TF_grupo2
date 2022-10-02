import { Reserva } from "./reserva";

export class UsuarioReserva {
  idUsuario : number;
  nombre : string;
  apellido : string;
  fechaNacimiento : Date;
  correo : string;
  reservasUsuario : Reserva[];
}
