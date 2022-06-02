import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Activity } from 'src/app/models/activity.model';
import { Employee } from 'src/app/models/employee.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponentActividad implements OnInit {
  activity: Activity = new Activity();
  employee: Employee = new Employee();
  employeeId: number = 0;


  constructor(private service:ServiceTestService, private router:Router) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    if(id == null){
      id = "0";
    }
    this.service.getActivityId(+id)
    .subscribe((data: any)=>{
      this.activity=data;
    })

  }
  Actualizar(activity:Activity,employeeId:number){
    this.service.getEmployeeId(+employeeId)
    .subscribe((data: any)=>{
      this.employee=data;
      this.activity.employee = this.employee;
      this.service.updateActivity(activity)
      .subscribe((data: any)=>{
        this.activity=data;
        alert("Se Actualizo con Exito...!!!");
        this.router.navigate(["listar-actividad"]);
      })
    })
    

    
  }



}
