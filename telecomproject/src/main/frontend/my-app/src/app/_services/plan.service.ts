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

  findAll(): Observable<HttpResponse<Plan[]>>{
    return this.http.get<Plan[]>(this.url, { observe: 'response'});
  }

  find(id: number): Observable<HttpResponse<Plan>>{
    return this.http.get<Plan>(this.url + `/${id}`, { observe: 'response'});
  }
}
