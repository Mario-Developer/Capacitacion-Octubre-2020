import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MostrarComponent} from './Avion/mostrar/mostrar.component';
import {GuardarComponent} from './Avion/guardar/guardar.component';
import {EditarComponent} from './Avion/editar/editar.component';
import {EliminarComponent} from './Avion/eliminar/eliminar.component';

const routes: Routes = [
  {path: 'mostrar', component:MostrarComponent},
  {path: 'guardar', component:GuardarComponent},
  {path: 'editar', component:EditarComponent},
  {path: 'eliminar', component:EliminarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
