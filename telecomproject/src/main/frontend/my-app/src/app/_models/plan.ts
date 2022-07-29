export class Plan {
    id!: number;
    planName: string;
    planPrice: number;
    planNumlines: number;
    userId: number;

    constructor(planName: string, planPrice: number, planNumlines: number, userId: number){
        this.planName = planName;
        this.planPrice = planPrice;
        this.planNumlines = planNumlines;
        this.userId = userId;
    }
}
