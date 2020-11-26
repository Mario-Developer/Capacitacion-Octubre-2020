import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Avion } from 'src/app/Entidad/Avion';
import { ServiciosService } from 'src/app/Servicios/servicios.service';
@Component({
  selector: 'app-mostrar',
  templateUrl: './mostrar.component.html',
  styleUrls: ['./mostrar.component.css']
})
export class MostrarComponent implements OnInit {
avion: Avion[];
  constructor(private servicios : ServiciosService, private router:Router) { }

  ngOnInit(): void {
    this.servicios.mostrarAviones().subscribe(data=>{
      this.avion=data;
    });    
  }

  Editar(avion: Avion): void{
    localStorage.setItem("id", avion.id.toString());
    this.router.navigate(["editar"]);
  }

  Eliminar(avion: Avion): void{
    localStorage.setItem("id", avion.id.toString());
    this.router.navigate(["eliminar"]);
  }
}
