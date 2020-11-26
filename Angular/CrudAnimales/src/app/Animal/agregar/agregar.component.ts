import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Animal } from 'src/app/Entidad/Animal';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})

export class AgregarComponent implements OnInit {

  constructor(private router: Router, private service: ServiceService) { }

  ngOnInit(): void {
  }

  animal:Animal = new Animal();
  
  Guardar(){
    this.service.agregarAnimal(this.animal).subscribe(data=>{
      alert("Se guardo el animal");
      this.router.navigate(["listar"]);
    })
  }
}
