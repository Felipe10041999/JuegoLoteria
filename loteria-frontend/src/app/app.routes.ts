import { Routes } from '@angular/router';
import { Juego } from './pages/juego/juego';
import { Login } from './pages/login/login';

export const routes: Routes = [
  { path: '', component: Juego },
  { path: 'login', component: Login }
];