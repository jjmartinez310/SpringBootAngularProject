import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'app/_models/device';
import { Plan } from 'app/_models/plan';
import { User } from 'app/_models/user';
import { DeviceService } from 'app/_services/device.service';
import { PlanService } from 'app/_services/plan.service';
import { UserService } from 'app/_services/user.service';

@Component({
  selector: 'app-user-plans',
  templateUrl: './user-plans.component.html',
  styleUrls: ['./user-plans.component.css']
})
export class UserPlansComponent implements OnInit {

  Plans: Plan[] = [];
  Devices?: Device[] = [];



  @Input() User?: User;
  TotalCost: number = 0;

  constructor(private planService: PlanService, private deviceService: DeviceService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.userService.findUser().subscribe(data => {
      if (data.body != null)
      sessionStorage.setItem('userId', data.body?.id.toString());

      this.planService.findPlansByUser(JSON.parse(sessionStorage.getItem('userId') || '{}')).subscribe((data) => {
        if (data.body != null) {
          this.Plans = data.body;
          for(let i = 0; i < this.Plans.length; i++){
            this.TotalCost += this.Plans[i].planPrice;
          }
          for (let i = 0; i < this.Plans.length; i++) {
            this.deviceService.findDevicesByPlan(this.Plans[i].id).subscribe((data) => {
              if (data.body != null) {
                this.Devices = data.body;
              }
            });
          }

        }

      });

    })
  };

  deletePlan(id: number): void {
    this.planService.deletePlan(id).subscribe((data) => {
      this.router.navigateByUrl('/home', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/profile']);
    });
    });
  }

  redirect() {
    this.router.navigateByUrl('/addplans');
  }
}
