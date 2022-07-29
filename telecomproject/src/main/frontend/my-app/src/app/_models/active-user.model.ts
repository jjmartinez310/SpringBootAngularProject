import { Device } from "./device"
import { Plan } from "./plan"

export class ActiveUser {
    id!: number;
    firstName: string;
    lastName: string;
    username: string;
    pass: string;
    plans: Array<Plan>;
    devices: Array<Device>;

    constructor(firstName: string, lastName: string, username: string, pass: string, plans: Array<Plan>, devices: Array<Device>) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.pass = pass;
            this.plans = plans;
            this.devices = devices
        }
}
