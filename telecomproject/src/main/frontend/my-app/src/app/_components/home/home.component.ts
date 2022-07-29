import { Component, OnInit } from '@angular/core';
import { User } from 'app/_models/user';
import { StateService } from 'app/_services/state.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  User?: User;
  title = "Home";

  constructor(private stateService: StateService) { }

  ngOnInit(): void {
    this.stateService.currentUser.subscribe(user => this.User = user)

  }

}
