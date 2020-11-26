import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Avion} from 'src/app/Entidad/Avion';
import { ServiciosService } from 'src/app/Servicios/servicios.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private router: Router, private service: ServiciosService) { }
  avion: Avion = new Avion();
  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.avion.id =+ id;
    this.service.buscarAviones(this.avion).subscribe(data=>{
      this.avion = data;
    })
  }

  Actualizar(avion: Avion){
    this.service.editarAviones(this.avion).subscribe(data=>{
      this.avion=data;
      alert("Se actualizo  el registro");
      this.router.navigate(["mostrar"]);
    })
  }
}
