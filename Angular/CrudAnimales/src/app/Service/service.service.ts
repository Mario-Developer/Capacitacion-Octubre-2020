import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Animal} from '../Entidad/Animal';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  animal: Animal
  constructor(private http:HttpClient) { }
  UrlListar = 'http://localhost:9002/CrudAngularAnimal/crudAngularAnimal/Animal/mostrar';
  UrlGuardar = 'http://localhost:9002/CrudAngularAnimal/crudAngularAnimal/Animal/guardar';
  UrlBuscar = 'http://localhost:9002/CrudAngularAnimal/crudAngularAnimal/Animal/buscar';
  UrlEditar = 'http://localhost:9002/CrudAngularAnimal/crudAngularAnimal/Animal/editar';
  UrlEliminar = 'http://localhost:9002/CrudAngularAnimal/crudAngularAnimal/Animal/eliminar';

  listarAnimales(){
    return this.http.get<Animal[]>(this.UrlListar);
  }
  agregarAnimal(animal : Animal){
    return this.http.post<Animal[]>(this.UrlGuardar, animal);
  }

  buscarAnimal(animal: Animal){
    return this.http.post<Animal>(this.UrlBuscar, animal);
  }

  editarAnimal(animal: Animal){
    return this.http.post<Animal>(this.UrlEditar, animal)
  }

  eliminarAnimal(animal: Animal){
    return this.http.post<Animal>(this.UrlEliminar, animal) 
  }
}
