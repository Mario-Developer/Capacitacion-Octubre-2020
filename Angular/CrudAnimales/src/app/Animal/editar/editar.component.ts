import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Animal } from 'src/app/Entidad/Animal';
import {ServiceService} from 'src/app/Service/service.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private router:Router, private service: ServiceService) { }
  animal : Animal = new Animal();
  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.animal.id = +id;
    this.service.buscarAnimal(this.animal).subscribe(data=> {
      this.animal = data;
    })
  }

  Actualizar(animal:Animal){
    this.service.editarAnimal(this.animal).subscribe(data=>{
      this.animal=data;
      alert("Se actualizo  el registro");
      this.router.navigate(["listar"]);
    })
  }
}
