import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './Animal/listar/listar.component';
import { AgregarComponent } from './Animal/agregar/agregar.component';
import { EditarComponent } from './Animal/editar/editar.component';
import { EliminarComponent } from './Animal/eliminar/eliminar.component';

import{FormsModule} from '@angular/forms';
import{ReactiveFormsModule} from '@angular/forms';
import{ServiceService} from '../app/Service/service.service';
import{HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    AgregarComponent,
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
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
