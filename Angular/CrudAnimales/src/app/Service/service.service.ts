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

  listarAnimales(){
    return this.http.get<Animal[]>(this.UrlListar);
  }
}
