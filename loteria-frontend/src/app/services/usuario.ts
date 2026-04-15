import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private api = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Usuario[]>(`${this.api}/usuarios`);
  }

  crear(usuario: any) {
    return this.http.post(`${this.api}/usuarios`, usuario);
  }

  login(nombre: string, password: string) {
    return this.http.post(`${this.api}/usuarios/login`, {
      nombre,
      password
    });
  }
}