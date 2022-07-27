import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from '../_models/user'
@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = "http://localhost:8080/api/users"

  constructor(private http: HttpClient) { }

  findAll(): Observable<HttpResponse<User[]>>{
    return this.http.get<User[]>(this.url, { observe: 'response'});
  }

  find(id: number): Observable<HttpResponse<User>>{
    return this.http.get<User>(this.url + `/${id}`, { observe: 'response'});
  }
}
