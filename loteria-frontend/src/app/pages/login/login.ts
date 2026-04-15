import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../services/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html'
})
export class Login {

  nombre = '';
  password = '';

  constructor(
    private usuarioService: UsuarioService,
    private router: Router) {}

  login() {

    this.usuarioService.login(this.nombre, this.password)
  .subscribe(user => {

    localStorage.setItem('user', JSON.stringify(user));

    this.router.navigate(['/']); // 👈 va al juego

    });
  }
}