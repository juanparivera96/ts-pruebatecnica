import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todosistemas-Juan Pablo Rivera';

  constructor(private router:Router){

  }

  ListarActividades(){
    this.router.navigate(["listar-actividad"]);
  }

  AgregarActividad(){
    this.router.navigate(["agregar-actividad"]);
  }


  ListarEmpleados(){
    this.router.navigate(["listar-empleado"]);
  }

  AgregarEmpleado(){
    this.router.navigate(["agregar-empleado"]);
  }
}
