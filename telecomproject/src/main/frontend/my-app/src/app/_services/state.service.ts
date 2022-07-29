import { Injectable } from '@angular/core';
import { User } from 'app/_models/user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateService {
  thisUser?: User;
  private UserSource = new BehaviorSubject<User>(this.thisUser!)
  currentUser = this.UserSource.asObservable();
  
  constructor() { }

  getUser() {
    return this.currentUser;
  }

  resetUser() {
    this.UserSource.next({id:0,firstName:"",lastName:"",username:"",pass:""})
  }

 changeUser(user: User) {
    this.UserSource.next(user);
  }
}
