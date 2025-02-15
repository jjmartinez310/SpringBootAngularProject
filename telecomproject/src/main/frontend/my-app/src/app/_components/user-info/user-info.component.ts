import { Component, Input, OnInit } from '@angular/core';
import { User } from 'app/_models/user';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  @Input() User?: User;

  constructor() { }

  ngOnInit(): void {
  };

}
