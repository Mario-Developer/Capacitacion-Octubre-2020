import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Avion } from 'src/app/Entidad/Avion';
import {ServiciosService} from 'src/app/Servicios/servicios.service';

@Component({
  selector: 'app-eliminar',
  templateUrl: './eliminar.component.html',
  styleUrls: ['./eliminar.component.css']
})
export class EliminarComponent implements OnInit {

  constructor(private router: Router, private service: ServiciosService) { }
  avion: Avion = new Avion();
  ngOnInit(): void {
    this.Buscar();
  }

  Buscar(){
    let id = localStorage.getItem("id");
    this.avion.id = +id;
    this.service.buscarAviones(this.avion).subscribe(data=> {
      this.avion = data;
    });
  }

  Eliminar(avion: Avion){
    this.service.eliminarAviones(this.avion).subscribe(data=>{
      this.avion=data;
      alert("Se eliminó  el registro");
      this.router.navigate(["mostrar"]);
    });
  }
}
