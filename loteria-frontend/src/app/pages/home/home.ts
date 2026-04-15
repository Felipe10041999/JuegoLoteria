import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  constructor(private http: HttpClient) {}

ngOnInit() {
  this.http.get('http://localhost:8080/')
    .subscribe(res => console.log(res));
}
}
