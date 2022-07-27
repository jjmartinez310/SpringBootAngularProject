import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../_models/user';
import { UserService } from '../_services/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  UserList!: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe((data) => {
      console.log("body: " + data)
      if (data.body != null){
        this.UserList = data.body;
        console.log(this.UserList);
      }
    });
  }

}
