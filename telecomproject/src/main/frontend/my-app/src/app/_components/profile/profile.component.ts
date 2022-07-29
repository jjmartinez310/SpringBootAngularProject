import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'app/_models/device';
import { Plan } from 'app/_models/plan';
import { User } from 'app/_models/user';
import { DeviceService } from 'app/_services/device.service';
import { PlanService } from 'app/_services/plan.service';
import { StateService } from 'app/_services/state.service';
import { UserService } from 'app/_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  User?: User;
  Plans: Plan[] = [];
  Devices?: Device[] = [];
  Device: Device | undefined;

  constructor(private userService: UserService, private planService: PlanService, private deviceService: DeviceService, private stateService: StateService, private router: Router) { }

  ngOnInit(): void {

    this.userService.findUser().subscribe((data)=>{
      if(data.body != null){
        sessionStorage.setItem('userId', data.body.id.toString());
        this.User = data.body;
        this.stateService.changeUser(this.User)
      }
    })
  }

}
