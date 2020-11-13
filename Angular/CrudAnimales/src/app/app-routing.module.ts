import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListarComponent} from './Animal/listar/listar.component';
import {AgregarComponent} from './Animal/agregar/agregar.component';
import {EditarComponent} from './Animal/editar/editar.component';
import {EliminarComponent} from './Animal/eliminar/eliminar.component';

const routes: Routes = [
  {path: 'listar', component:ListarComponent},
  {path: 'guardar', component:AgregarComponent},
  {path: 'editar', component:EditarComponent},
  {path: 'eliminar', component:EliminarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
