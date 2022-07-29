import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from '../_models/user'
@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = "http://localhost:8080/users"

  constructor(private http: HttpClient) { }

    findUser(): Observable<HttpResponse<User>> {
      return this.http.get<User>(this.url + "/" + sessionStorage.getItem("username"), {observe: 'response',withCredentials: true});
    }
    
    saveUser(user: User): Observable<HttpResponse<User>> {
      return this.http.post<User>(this.url + "/signup", user, {observe: 'response'});
    }
  
    updateUser(user: User): Observable<HttpResponse<User>> {
      return this.http.put<User>(this.url, user, {observe: 'response',withCredentials: true});
    }
  
    deleteUser(id: number): Observable<HttpResponse<User>> {
      return this.http.delete<User>(this.url, {observe: 'response',withCredentials: true});
    }
}
