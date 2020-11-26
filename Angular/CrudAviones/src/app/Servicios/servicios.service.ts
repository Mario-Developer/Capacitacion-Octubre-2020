import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Avion} from '../Entidad/Avion';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {
avion: Avion
  constructor(private http:HttpClient) { }
  UrlMostrar = 'http://localhost:9002/CrudAngularAvion/crudAngularAvion/Avion/mostrar';
  UrlGuardar = 'http://localhost:9002/CrudAngularAvion/crudAngularAvion/Avion/guardar';
  UrlBuscar = 'http://localhost:9002/CrudAngularAvion/crudAngularAvion/Avion/buscar';
  UrlEditar = 'http://localhost:9002/CrudAngularAvion/crudAngularAvion/Avion/editar';
  UrlEliminar = 'http://localhost:9002/CrudAngularAvion/crudAngularAvion/Avion/eliminar';

  mostrarAviones(){
    return this.http.get<Avion[]>(this.UrlMostrar);
  }

  guardarAviones(avion: Avion){
    return this.http.post<Avion[]>(this.UrlGuardar, avion);
  }

  buscarAviones(avion: Avion){
    return this.http.post<Avion>(this.UrlBuscar, avion);
  }

  editarAviones(avion: Avion){
    return this.http.post<Avion>(this.UrlEditar, avion);
  
  }
  eliminarAviones(avion: Avion){
    return this.http.post<Avion>(this.UrlEliminar, avion);
  }
}
