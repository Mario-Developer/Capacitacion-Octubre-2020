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

  listarAnimales(){
    return this.http.get<Animal[]>(this.UrlListar);
  }
  agregarAnimal(){
    return this.http.post<Animal[]>(this.UrlGuardar, animal);
  }
}
