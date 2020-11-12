import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListarComponent} from './Animal/listar/listar.component';
import {AgregarComponent} from './Animal/agregar/agregar.component';

const routes: Routes = [
  {path: 'listar', component:ListarComponent},
  {path: 'guardar', component:AgregarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
