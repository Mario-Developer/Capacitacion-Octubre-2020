import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Avion } from 'src/app/Entidad/Avion';
import { ServiciosService } from 'src/app/Servicios/servicios.service';

@Component({
  selector: 'app-guardar',
  templateUrl: './guardar.component.html',
  styleUrls: ['./guardar.component.css']
})
export class GuardarComponent implements OnInit {

  constructor(private servicio: ServiciosService, private router: Router) { }

  ngOnInit(): void {
  }

  avion: Avion = new Avion();

  Guardar(){
    this.servicio.guardarAviones(this.avion).subscribe(data=>{
      alert("Se guardo avion");
      this.router.navigate(["mostrar"]);
    })
  }

}
