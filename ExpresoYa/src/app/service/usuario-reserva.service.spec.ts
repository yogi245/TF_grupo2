import { TestBed } from '@angular/core/testing';

import { UsuarioReservaService } from './usuario-reserva.service';

describe('UsuarioReservaService', () => {
  let service: UsuarioReservaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsuarioReservaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
