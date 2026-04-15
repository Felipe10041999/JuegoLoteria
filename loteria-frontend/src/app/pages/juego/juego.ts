import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-juego',
  imports: [],
  templateUrl: './juego.html',
  styleUrl: './juego.css',
})
export class Juego {
  usuarios: any[] = [];

  constructor( private router: Router) {}

  ngOnInit() {
    const user = localStorage.getItem('user');

    if (!user) {
      this.router.navigate(['/login']); // 🚀 redirección automática
      return;
    }

    console.log('Usuario logueado:', JSON.parse(user));
  }
}
