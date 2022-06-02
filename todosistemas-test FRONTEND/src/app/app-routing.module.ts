import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgregarComponentActividad } from './Actividad/agregar/agregar.component';
import { EditarComponentActividad } from './Actividad/editar/editar.component';
import { ListarComponentActividad } from './Actividad/listar/listar.component' ;
import { AgregarComponentEmpleado } from './Empleado/agregar/agregar.component';
import { EditarComponentEmpleado } from './Empleado/editar/editar.component';
import { ListarComponentEmpleado } from './Empleado/listar/listar.component';

const routes: Routes = [
  {path: 'listar-actividad', component: ListarComponentActividad},
  {path: 'agregar-actividad', component: AgregarComponentActividad},
  {path: 'editar-actividad', component: EditarComponentActividad},
  {path: 'listar-empleado', component: ListarComponentEmpleado},
  {path: 'agregar-empleado', component: AgregarComponentEmpleado},
  {path: 'editar-empleado', component: EditarComponentEmpleado},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
