export class User {
    id!: number;
    firstName: string;
    lastName: string;
    username: string;
    pass: string;


    constructor(first_name: string, last_name: string, username: string, pass: string){
        this.firstName = first_name;
        this.lastName = last_name;
        this.username = username;
        this.pass = pass;
    }
}
