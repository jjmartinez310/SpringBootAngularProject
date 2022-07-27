export class Device {
    device_id: number;
    device_name: string;
    device_number: string;
    device_model: string;
    plan_id: number;

    constructor(device_id: number, device_name:string, device_number: string, device_model: string, plan_id: number){
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_number = device_number;
        this.device_model = device_model;
        this.plan_id = plan_id;
    }
}
