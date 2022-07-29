import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Device } from '../_models/device'
@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  url: string = "http://localhost:8080/devices"

  constructor(private http: HttpClient) { }

  findDevicesByPlan(planId: number): Observable<HttpResponse<Device[]>> {
    return this.http.get<Device[]>(this.url + `/${planId}`, {observe: 'response', withCredentials: true});
  }

  findDeviceById(deviceId: number): Observable<HttpResponse<Device>> {
    return this.http.get<Device>(this.url + `/${deviceId}`, {observe: 'response', withCredentials: true});
  }

  saveDevice(device: Device): Observable<HttpResponse<Device>> {
    return this.http.post<Device>(this.url + "/newdevice", device, {observe: 'response', withCredentials: true});
  }

  updateDevice(device: Device, deviceId: number): Observable<HttpResponse<Device>> {
    return this.http.put<Device>(this.url + `/update/${deviceId}`, device, {observe: 'response', withCredentials: true});
  }

  deleteDevice(id: number): Observable<HttpResponse<Device>> {
    return this.http.delete<Device>(this.url + '/' + id, {observe: 'response', withCredentials: true});
  }

}
