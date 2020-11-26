import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CrudAviones';

  constructor(private router:Router){}
  Mostrar(){
    this.router.navigate(["mostrar"]);
  }
  Guardar(){
    this.router.navigate(["guardar"])
  }
}
