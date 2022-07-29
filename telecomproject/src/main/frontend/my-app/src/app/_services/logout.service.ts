import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StateService } from './state.service';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {
  url: string = "http://localhost:8080/logout";
  constructor(private http: HttpClient, private stateService: StateService){}

  logout(): Observable<HttpResponse<any>>{this.stateService.resetUser();
    return this.http.get(this.url, {observe: 'response', withCredentials: true});
  }

}
