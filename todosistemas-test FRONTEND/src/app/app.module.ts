import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListarComponentActividad } from './Actividad/listar/listar.component';
import { AgregarComponentActividad } from './Actividad/agregar/agregar.component';
import { EditarComponentActividad } from './Actividad/editar/editar.component';
import { FormsModule }from '@angular/forms';
import { ServiceTestService } from '../app/service/service-test.service';
import { HttpClientModule } from '@angular/common/http';
import { MatNativeDateModule } from '@angular/material/core';
import { ListarComponentEmpleado } from './Empleado/listar/listar.component';
import { AgregarComponentEmpleado } from './Empleado/agregar/agregar.component';
import { EditarComponentEmpleado } from './Empleado/editar/editar.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarComponentActividad,
    AgregarComponentActividad,
    EditarComponentActividad,
    ListarComponentEmpleado,
    AgregarComponentEmpleado,
    EditarComponentEmpleado],

  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule, 
    MatNativeDateModule


  ],
  providers: [ServiceTestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
