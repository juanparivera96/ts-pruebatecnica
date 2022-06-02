import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Activity } from 'src/app/models/activity.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponentActividad implements OnInit {

  activities: Activity[] = [];
  constructor(private service:ServiceTestService, private router:Router) { }

  ngOnInit()  {
    this.service.getActivities()
    .subscribe((data: Activity[])=>{
      this.activities=data;
    })
  }

  Editar(activity:Activity):void{
    localStorage.setItem("id",activity.id.toString());
    this.router.navigate(["editar-actividad"]);
  }

  Eliminar(activity:Activity){
    this.service.deleteActivity(activity)
    .subscribe((data: any)=>{
      this.activities=this.activities.filter(a=>a!==activity);
      alert("Actividad eliminada!");
    })
  }

}


