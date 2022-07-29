export class Device {
    id!: number;
    deviceName: string;
    deviceNumber: string;
    deviceModel: string;
    planId: number;

    constructor(deviceName:string, deviceNumber: string, deviceModel: string, planId: number){
        this.deviceName = deviceName;
        this.deviceNumber = deviceNumber;
        this.deviceModel = deviceModel;
        this.planId = planId;
    }
}
