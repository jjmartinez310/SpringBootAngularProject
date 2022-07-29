import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'app/_services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = {username: '', pass: ''}
  errorMessage: string = 'Enter a valid username and password to log in)';

  callback(): void {

  }

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.loginService.authenticate(this.credentials)
    .subscribe(
    (data) => {this.router.navigateByUrl('/profile');}, 
    (error:Error)=>{this.errorMessage = this.handleError(error);
    });
  }

  handleError(error:any) {
    let message = '';
    if (error.error instanceof ErrorEvent) {
      message = 'Unexpected Error Has Occured';
    } else {
      message = 'Invalid Username/Password'
    }
    this.errorMessage! = message;
    return message;
  }

}
