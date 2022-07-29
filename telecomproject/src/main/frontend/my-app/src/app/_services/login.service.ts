import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "../_models/user";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url: string = "http://localhost:8080/login"

  constructor(private http:HttpClient){}
  User?: User;
  authenticate(credentials: {username: any; pass: any}): Observable<HttpResponse<FormData>>{

    sessionStorage.setItem('username',credentials.username);
    const formData = new FormData();
    formData.append('username', credentials.username);
    formData.append('password', credentials.pass);

    return this.http.post<FormData>(this.url, formData, {observe:'response', withCredentials: true});
  }
}
