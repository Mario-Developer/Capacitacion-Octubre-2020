import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MostrarComponent } from './Avion/mostrar/mostrar.component';
import { GuardarComponent } from './Avion/guardar/guardar.component';
import { EditarComponent } from './Avion/editar/editar.component';
import { EliminarComponent } from './Avion/eliminar/eliminar.component';

import{FormsModule} from '@angular/forms';
import{ReactiveFormsModule} from '@angular/forms';
import{ServiciosService} from '../app/Servicios/servicios.service';
import{HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MostrarComponent,
    GuardarComponent,
    EditarComponent,
    EliminarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ServiciosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
