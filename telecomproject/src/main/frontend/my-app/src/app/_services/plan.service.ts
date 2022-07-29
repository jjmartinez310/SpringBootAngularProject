import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Plan } from '../_models/plan'
@Injectable({
  providedIn: 'root'
})
export class PlanService {
  url: string = "http://localhost:8080/plans"

  constructor(private http: HttpClient) { }

  findPlansByUser(userId: number): Observable<HttpResponse<Plan[]>> {
    return this.http.get<Plan[]>(this.url + `/${userId}`, {observe: 'response', withCredentials: true});
  }

  findPlanById(planId: number): Observable<HttpResponse<Plan>> {
    return this.http.get<Plan>(this.url + `/plan/${planId}`, {observe: 'response', withCredentials: true});
  }

  savePlan(plan: Plan): Observable<HttpResponse<Plan>> {
    return this.http.post<Plan>(this.url + "/newplan", plan, {observe: 'response', withCredentials: true});
  }

  updatePlan(plan: Plan): Observable<HttpResponse<Plan>> {
    return this.http.put<Plan>(this.url + `/update/${plan.id}`, plan, {observe: 'response', withCredentials: true});
  }

  deletePlan(id: number): Observable<HttpResponse<Plan>> {
    return this.http.delete<Plan>(this.url + '/' + id, {observe: 'response', withCredentials: true});
  }
}
