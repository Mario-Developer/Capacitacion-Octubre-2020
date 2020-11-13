import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Animal } from 'src/app/Entidad/Animal';
import {ServiceService} from 'src/app/Service/service.service';

@Component({
  selector: 'app-eliminar',
  templateUrl: './eliminar.component.html',
  styleUrls: ['./eliminar.component.css']
})
export class EliminarComponent implements OnInit {

  constructor(private router:Router, private service: ServiceService) { }
  animal : Animal = new Animal();
  ngOnInit(): void {
    this.Buscar();
  }

  Buscar(){
    let id = localStorage.getItem("id");
    this.animal.id = +id;
    this.service.buscarAnimal(this.animal).subscribe(data=> {
      this.animal = data;
    });
  }

  Eliminar(animal:Animal){
    this.service.eliminarAnimal(this.animal).subscribe(data=>{
      this.animal=data;
      alert("Se eliminó  el registro");
      this.router.navigate(["listar"]);
    });
  }

}
