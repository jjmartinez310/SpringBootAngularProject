import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'app/_models/user';
import { UserService } from 'app/_services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  credentials = {firstName: '', lastName: '', username: '', pass: ''};
  newUser: User = new User (this.credentials.firstName, this.credentials.lastName, this.credentials.username, this.credentials.pass); 
  errorMessage: string = '';

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    
    this.newUser.firstName = this.credentials.firstName;
    this.newUser.lastName= this.credentials.lastName;
    this.newUser.username = this.credentials.username;
    this.newUser.pass = this.credentials.pass;
    if (this.newUser.firstName.trim() != "" && this.newUser.lastName.trim() && this.newUser.username != "") {
      this.userService.saveUser(this.newUser).subscribe(data => {
        
        let route = this.router.config.find(res => res.path === 'login');
        if (route) {
          this.router.navigateByUrl('/login');
        }
      }, (error:Error)=>{
        this.errorMessage = this.handleError(error);
      });
    }
  }

  handleError(error:any) {
    let message = '';
    if (error.error instanceof ErrorEvent) {
      message = 'Unexpected Error';
    } else {
      message = 'Email already associated with an account.'
    }
    console.log(message);
    this.errorMessage! = message;
    return message;
  }
}