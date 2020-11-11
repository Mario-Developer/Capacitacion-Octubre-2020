import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarPipe } from './Animales/listar.pipe';
import { GuardarPipe } from './Animales/guardar.pipe';
import { EditarPipe } from './Animales/editar.pipe';
import { EliminarPipe } from './Animales/eliminar.pipe';
import { BuscarPipe } from './Animales/buscar.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ListarPipe,
    GuardarPipe,
    EditarPipe,
    EliminarPipe,
    BuscarPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
