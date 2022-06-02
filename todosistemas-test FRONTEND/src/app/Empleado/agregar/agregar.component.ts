import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponentEmpleado implements OnInit {

  employee: Employee = new Employee();
  constructor(private router:Router, private service:ServiceTestService) { }

  ngOnInit() {
  }


  GuardarEmpleado(){
    this.service.createEmployee(this.employee)
    .subscribe((data: any)=>{
      alert("Se agrego un nuevo Empleado");
      this.router.navigate(["listar-empleado"]);
    })
  }

}
