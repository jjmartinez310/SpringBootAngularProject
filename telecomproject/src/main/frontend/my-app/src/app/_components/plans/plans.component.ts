import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'app/_models/device';
import { Plan } from 'app/_models/plan';
import { User } from 'app/_models/user';
import { DeviceService } from 'app/_services/device.service';
import { PlanService } from 'app/_services/plan.service';
import { StateService } from 'app/_services/state.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {

  userId = JSON.parse(sessionStorage.getItem('userId') || '{}');
  Plan: Plan = new Plan("newPlan", 0.0, 0, this.userId);
  phonePlan: string = "newPlan";
  lines: string[] = [""];
  errorMessage: string = '';
  duplicate: boolean = false;
  warningMessage: string = '';

  selected: boolean = false;

  constructor(private planService: PlanService, private deviceService: DeviceService, private router: Router) { }

  typeOf(any: any) {
    return typeof (any);
  }

  increment() {
    let currentPhones = document.getElementById("currentPhones");
    let maxPhones = document.getElementById("maxPhones");
    if (currentPhones && maxPhones) {
      if (Number(currentPhones.innerHTML) < Number(maxPhones.innerHTML)) {
        currentPhones.innerHTML = String(Number(currentPhones.innerHTML) + 1);
        this.lines.push("");
      }
    }
  }
  decrement() {
    let currentPhones = document.getElementById("currentPhones");
    if (currentPhones) {
      if (this.lines.length > 1) {
        currentPhones.innerHTML = String(Number(currentPhones.innerHTML) - 1);
        this.lines.pop();
      }

    }
  }

  selectPlan(p: string) {
    var plan1 = document.getElementById("plan1");
    var plan2 = document.getElementById("plan2");
    var plan3 = document.getElementById("plan3");
    if (p == 'SINGLE') {
      this.phonePlan = 'SINGLE';
      plan1?.classList.add('selected');
      this.selected = true;
      let currentPhones = document.getElementById("currentPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (currentPhones && maxPhones) {
        maxPhones.innerHTML = "1";
        currentPhones.innerHTML = "1";

      }
      while (this.lines.length > 1) {
        this.lines.pop();
      }
      this.Plan.planName = "Single";
      this.Plan.planPrice = 24.99;
      this.Plan.planNumlines = 1;
    }
    else {
      plan1?.classList.remove('selected');
    }
    if (p == 'ECONOMY') {
      this.phonePlan = 'ECONOMY';
      plan2?.classList.add('selected');
      this.selected = true;
      let currentPhones = document.getElementById("currentPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (currentPhones && maxPhones) {
        maxPhones.innerHTML = "3";

        while (this.lines.length > 3) {
          this.lines.pop();
          currentPhones.innerHTML = "3";
        }
      }
      this.Plan.planName = "ECONOMY";
      this.Plan.planPrice = 69.99;
      this.Plan.planNumlines = 3;
    }
    else {
      plan2?.classList.remove('selected');
    }
    if (p == 'FAMILY') {
      this.phonePlan = 'FAMILY';
      plan3?.classList.add('selected');
      this.selected = true;
      let currentPhones = document.getElementById("currentPhones");
      let maxPhones = document.getElementById("maxPhones");
      if (currentPhones && maxPhones) {

        maxPhones.innerHTML = "6";

      }
      this.Plan.planName = "FAMILY";
      this.Plan.planPrice = 129.99;
      this.Plan.planNumlines = 6;
    }
    else {
      plan3?.classList.remove('selected');
    }

    this.selected = true;
  }
  submitPlan() {
    let Devices: Device[] = [];
    if (!this.duplicate) {
      let nameDiv = document.querySelectorAll('[id=name]');
      let names = [];
      let phoneDiv = document.querySelectorAll('[id=phone]');
      let phoneNumbers = [];
      let modelDiv = document.querySelectorAll('[id=model]');
      let models = [];

      for (let i = 0; i < phoneDiv.length; i++) {
        if ((nameDiv[i] as HTMLInputElement).value == "") {
          alert("complete the phone name input");
          return;
        }
        names.push((phoneDiv[i] as HTMLInputElement).value);
        if ((phoneDiv[i] as HTMLInputElement).value == "") {
          alert("complete the phone number input");
          return;
        }
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);

        if ((modelDiv[i] as HTMLInputElement).value == "") {
          alert("complete the phone model input");
          return;
        }
        models.push((modelDiv[i] as HTMLInputElement).value);
        Devices.push(new Device((nameDiv[i] as HTMLInputElement).value, (modelDiv[i] as HTMLInputElement).value, (phoneDiv[i] as HTMLInputElement).value, this.Plan.id));
      }
        if (this.phonePlan == "noplan") {
          alert('please select a plan');
        }
        else {

          if (this.selected === true) {

            try {
              this.planService.savePlan(this.Plan).subscribe(data => {
                if (data.body != null || data.body != undefined) {
                  this.Plan = data.body
                }

                for (let i = 0; i < Devices.length; i++) {
                  Devices[i].planId = this.Plan.id
                  this.deviceService.saveDevice(Devices[i]).subscribe(data => {
                    setTimeout(() => this.router.navigateByUrl('/profile'), 2500);
                  }, (error: Error) => {
                    this.errorMessage = this.handleError(error);
                  })
                }


              });
            } catch (e) {
              console.log("error")
            }



          }

        }

    }
  }

  ngOnInit(): void {
    this.planService.findPlansByUser(this.userId).subscribe((data) => {
      if (data.body != null) {
      }
    });
  }

  handleError(error: any) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      msg = 'Unexpected Error';
    } else {
      msg = 'ERROR: Phone number(s) already tied to a different plan.'
    }
    console.log(msg);
    this.errorMessage! = msg;
    return msg;
  }

  changeHandler() {
    let phoneDiv = document.querySelectorAll('[id=phone]');
    let phoneNumbers: string[] = [];

    for (let i = 0; i < phoneDiv.length; i++) {
      if ((phoneDiv[i] as HTMLInputElement).value != '') {
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);
      }
    }

    let dup = false;
    dup = phoneNumbers.some((element, index) => {
      return phoneNumbers.indexOf(element) !== index
    });
    if (dup) {
      this.warningMessage = 'ERROR: Duplicate numbers';
      this.duplicate = true;
    } else {
      this.warningMessage = '';
      this.duplicate = false;
    }
  }

}

