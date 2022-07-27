export class Plan {
    plan_id: number;
    plan_name: string;
    plan_price: number;
    plan_numlines: number;
    user_id: number;

    constructor(plan_id: number, plan_name: string, plan_price: number, plan_numlines: number, user_id: number){
        this.plan_id = plan_id;
        this.plan_name = plan_name;
        this.plan_price = plan_price;
        this.plan_numlines = plan_numlines;
        this.user_id = user_id;
    }
}
