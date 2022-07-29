import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Device } from "app/_models/device";
import { Plan } from "app/_models/plan";
import { DeviceService } from "app/_services/device.service";
import { PlanService } from "app/_services/plan.service";


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})



export class EditComponent implements OnInit {

  phones: string[] = [""];
  Plan: Plan | undefined;
  Devices: Device[] = [];
  errorMessage: string ='';
  warningMessage: string = '';
  duplicate: boolean = false;

  constructor(private planService: PlanService, private deviceService: DeviceService, private route: ActivatedRoute, private router: Router) {
  }

  updatePlan(){
    if (!this.duplicate){
      let nameDiv = document.querySelectorAll('[id=name')
      let names = [];
      let phoneDiv = document.querySelectorAll('[id=phone]');
      let phoneNumbers = [];
      let modelDiv = document.querySelectorAll('[id=model]');
      let models = [];

    let NewDevices: Device[] = [];
    this.route.params.subscribe(params=>{

      for (let i = 0; i < phoneDiv.length; i++) {
        if ((nameDiv[i] as HTMLInputElement).value == "") {
          alert("Finish inputting a phone name");
          return;
        }
        names.push((nameDiv[i] as HTMLInputElement).value);

        if ((phoneDiv[i] as HTMLInputElement).value == "") {
          alert("Finish inputting a phone number");
          return;
        }
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);

        if ((modelDiv[i] as HTMLInputElement).value == "") {
          alert("Finish inputting a phone model");
          return;
        }
        models.push((modelDiv[i] as HTMLInputElement).value);

        NewDevices.push(new Device((nameDiv[i] as HTMLInputElement).value, (phoneDiv[i] as HTMLInputElement).value, (modelDiv[i] as HTMLInputElement).value,  params['id']))
      }

        for (let i = 0; i <= this.Devices.length - 1; i++) {
          if(this.Devices[i].deviceNumber == ''){
            this.deviceService.saveDevice(NewDevices[i]).subscribe(data => {
              this.router.navigateByUrl('/profile');
            }, (error:Error)=>{
              this.errorMessage = this.handleError(error);
            });
          }
          else {
            this.deviceService.updateDevice(NewDevices[i], this.Devices[i].id).subscribe(data => {
              this.router.navigateByUrl('/profile');
            }, (error:Error)=>{
              this.errorMessage = this.handleError(error);
            });
          }

        }
      })};
  }

  deleteDevice(deviceId: number, indexOf: number): void{
    let currentPhones = document.getElementById("currentPhones");

    if(deviceId){
      this.deviceService.deleteDevice(deviceId).subscribe(data => {
        this.Devices.splice(indexOf, 1);
      });
    }
    else {
      this.Devices.splice(indexOf, 1);
    }
    if(currentPhones)
      currentPhones.innerHTML = String(Number(currentPhones.innerHTML) - 1)

  }


  planType(planName: string){

    if(planName == "SINGLE"){
      var plan1 = document.getElementById("plan1");
      plan1?.classList.add('selected');

      let maxPhones = document.getElementById("maxPhones");
      if(maxPhones){
        maxPhones.innerHTML = "1";
      }
    }
    else{
      var plan1 = document.getElementById("plan1");
      plan1?.classList.add('no-select');
    }
    if(planName == "ECONOMY"){
      var plan2 = document.getElementById("plan2");
      plan2?.classList.add('selected');

      let maxPhones = document.getElementById("maxPhones");
      if(maxPhones){
        maxPhones.innerHTML = "3";
      }
    }
    else{
      var plan2 = document.getElementById("plan2");
      plan2?.classList.add('no-select');
    }
    if(planName == "FAMILY"){
      var plan3 = document.getElementById("plan3");
      plan3?.classList.add('selected');
      let maxPhones = document.getElementById("maxPhones");
      if(maxPhones){
        maxPhones.innerHTML = "6";
      }
    }
    else{
      var plan3 = document.getElementById("plan3");
      plan3?.classList.add('no-select');
    }


  }
  increment() {
    let currentPhones = document.getElementById("currentPhones");
    let maxPhones = document.getElementById("maxPhones");
    if(currentPhones && maxPhones){
      if(Number(currentPhones.innerHTML) < Number(maxPhones.innerHTML)){
        currentPhones.innerHTML = String(Number(currentPhones.innerHTML) + 1);
        this.Devices.push(new Device("", "", "" , -1));
      }
    }
  }


  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      let id = params['id'];
      this.planService.findPlanById(id).subscribe((data) => {

        if(data.body != null){
          this.Plan = data.body;
          this.planType(data.body.planName);
          this.deviceService.findDevicesByPlan(id).subscribe((data) => {
            if (data.body != null) {
              this.Devices = data.body;
              for(let i = 0; i < this.Devices.length-1; i++){
                this.phones.push("");
              }
              let currentPhones = document.getElementById("currentPhones");
              if(currentPhones){
                currentPhones.innerHTML = String(this.phones.length);
              }
              let nameDiv = document.querySelectorAll('[id=name]')
              let phoneDiv = document.querySelectorAll('[id=model]');
              let modelDiv = document.querySelectorAll('[id=phone]');
              for (let i = 0; i < phoneDiv.length; i++) {
                (nameDiv[i] as HTMLInputElement).value = this.Devices[i].deviceName;
                (phoneDiv[i] as HTMLInputElement).value = this.Devices[i].deviceNumber;
                (modelDiv[i] as HTMLInputElement).value = this.Devices[i].deviceModel;
              }
            }
          });
        }
      });
    });
  }

  handleError(error:any) {
    let message = '';
    if (error.error instanceof ErrorEvent) {
      message = 'Unexpected Error';
    } else {
      message = 'ERROR: Phone number(s) already tied to a different plan.'
    }
    console.log(message);
    this.errorMessage! = message;
    return message;
  }

  changeHandler() {
    let phoneDiv = document.querySelectorAll('[id=phone]');
    let phoneNumbers: string[] = [];

    for (let i = 0; i < phoneDiv.length; i++) {
      if ((phoneDiv[i] as HTMLInputElement).value != ''){
        phoneNumbers.push((phoneDiv[i] as HTMLInputElement).value);
      }
    }
    
    let dup = false;
    dup = phoneNumbers.some((element, index)=>{
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
