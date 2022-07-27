import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from '../_models/device';
import { DeviceService } from '../_services/device.service';


@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {
  DeviceList!: Device[];

  constructor(private deviceService: DeviceService, private router: Router) { }

  ngOnInit(): void {
    this.deviceService.findAll().subscribe((data) => {
      console.log("body: " + data)
      if (data.body != null){
        this.DeviceList = data.body;
        console.log(this.DeviceList);
      }
    });
  }

}
