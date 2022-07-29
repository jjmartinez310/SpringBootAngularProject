import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './_components/home/home.component';
import { LoginComponent } from './_components/login/login.component';
import { PlansComponent } from './_components/plans/plans.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { SignupComponent } from './_components/signup/signup.component';

const routes: Routes = [
  {
    path: '', redirectTo:'home', pathMatch: 'full'
  },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'profile', component: ProfileComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'signup', component: SignupComponent
  },
  {
    path: 'addPlans', component: PlansComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
