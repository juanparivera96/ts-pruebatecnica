import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponentEmpleado implements OnInit {

  employee: Employee = new Employee();
  constructor(private service:ServiceTestService, private router:Router) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    if(id == null){
      id = "0";
    }
    this.service.getEmployeeId(+id)
    .subscribe((data: any)=>{
      this.employee=data;
    })

  }
  Actualizar(employee:Employee){
    this.service.updateEmployee(employee)
    .subscribe((data: any)=>{
      this.employee=data;
      alert("Se Actualizo con Exito...!!!");
      this.router.navigate(["listar-empleado"]);
    })
  }


}
