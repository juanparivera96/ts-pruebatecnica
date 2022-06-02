import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponentEmpleado implements OnInit {

  employees: Employee[] = [];
  constructor(private service:ServiceTestService, private router:Router) { }

  ngOnInit()  {
    this.service.getEmployees()
    .subscribe((data: Employee[])=>{
      this.employees=data;
    })
  }

  Editar(employee:Employee):void{
    localStorage.setItem("id",employee.id.toString());
    this.router.navigate(["editar-empleado"]);
  }

  Eliminar(employee:Employee){
    this.service.deleteEmployee(employee)
    .subscribe((data: any)=>{
      this.employees=this.employees.filter(e=>e!==employee);
      alert("Empleado eliminado!");
    })
  }


}
