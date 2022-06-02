import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Activity } from 'src/app/models/activity.model';
import { ServiceTestService } from 'src/app/service/service-test.service';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponentActividad implements OnInit {

  activity: Activity = new Activity();
  constructor(private router:Router, private service:ServiceTestService) { }

  ngOnInit() {
  }


  GuardarActividad(){
    this.service.createActivity(this.activity)
    .subscribe((data: any)=>{
      alert("Se agrego una nueva actividad");
      this.router.navigate(["listar-actividad"]);
    })
  }
}
