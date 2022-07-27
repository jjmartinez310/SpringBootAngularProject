export class User {
    user_id: number;
    first_name: string;
    last_name: string;
    username: string;
    pass: string;


    constructor(user_id: number, first_name: string, last_name: string, username: string, pass: string){
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.pass = pass;
    }
}
