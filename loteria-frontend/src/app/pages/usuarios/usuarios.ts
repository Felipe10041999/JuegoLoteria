import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './usuarios.html'
})
export class UsuariosComponent implements OnInit {

  usuarios: any[] = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.listar().subscribe(data => {
      this.usuarios = data;
    });
  }
}