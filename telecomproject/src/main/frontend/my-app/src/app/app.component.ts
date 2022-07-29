import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './_models/user';
import { LoginService } from './_services/login.service';
import { LogoutService } from './_services/logout.service';
import { StateService } from './_services/state.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  credentials = {username: '', password: ''}
  title = 'my-app';
  User?: User;
  userId = JSON.parse(sessionStorage.getItem('userId')||'{}');

  constructor(private login: LoginService, private stateService: StateService, private logoutService: LogoutService, private http: HttpClient, private router: Router){}

  ngOnInit(): void {
      this.stateService.currentUser.subscribe(user => this.User = user)
  }

  typeOf(any: any){
    return typeof(any);
  }

  logout(){
    this.logoutService.logout().subscribe((data)=>{});
    sessionStorage.clear();
    this.router.navigateByUrl('/home', { skipLocationChange: true}).then(() =>{
      this.router.navigate(['/login']);
    })
  }
}
