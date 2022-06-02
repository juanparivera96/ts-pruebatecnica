import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Activity } from '../models/activity.model';
import { Employee } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class ServiceTestService {

  constructor(private http:HttpClient) { }

  url = "http://localhost:8080";

  getActivities(){
    return this.http.get<Activity[]>(this.url+"/activity/find-all");
  }

  createActivity(activity: Activity){
    return this.http.post<Activity[]>(this.url+"/activity/create",activity);
  }

  getActivityId(id:number){
    return this.http.get<Activity>(this.url+"/activity/findbyid/"+id);
  }
  updateActivity(activity:Activity){
    return this.http.put<Activity>(this.url+"/activity/update/"+activity.id,activity);
  }
  deleteActivity(activity:Activity){
    return this.http.delete<Activity>(this.url+"/activity/delete/"+activity.id);
  }


  getEmployees(){
    return this.http.get<Employee[]>(this.url+"/employee/find-all");
  }

  createEmployee(employee: Employee){
    return this.http.post<Activity[]>(this.url+"/employee/create",employee);
  }

  getEmployeeId(id:number){
    return this.http.get<Employee>(this.url+"/employee/findbyid/"+id);
  }
  updateEmployee(employee:Employee){
    return this.http.put<Employee>(this.url+"/employee/update/"+employee.id,employee);
  }
  deleteEmployee(employee:Employee){
    return this.http.delete<Employee>(this.url+"/employee/delete/"+employee.id);
  }
}
