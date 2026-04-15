import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { UsuarioService } from '../../services/usuario';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [CommonModule, FormsModule], 
  templateUrl: './usuarios.html'
})
export class Usuarios implements OnInit {

  usuarios: any[] = [];

  nombre: string = '';
  saldo: number = 0;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios() {
    this.usuarioService.listar().subscribe(data => {
      this.usuarios = data;
      console.log("Usuarios cargados:", data); // 👈 DEBUG
    });
  }

  crearUsuario() {
      if (!this.nombre || this.saldo <= 0) {
      return;
    }

    const nuevo = {
      nombre: this.nombre,
      saldo: this.saldo
    };

    this.usuarioService.crear(nuevo).subscribe(res => {

      this.usuarios = [...this.usuarios, res];

      // 🧹 limpiar inputs
      this.nombre = '';
      this.saldo = null as any;

    });
  }
}