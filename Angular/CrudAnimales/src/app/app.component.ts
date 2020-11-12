import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CrudAnimales';

  constructor(private router:Router){}
  Listar(){
    this.router.navigate(["listar"]);
  }
  Guardar(){
    this.router.navigate(["guardar"])
  }
}
