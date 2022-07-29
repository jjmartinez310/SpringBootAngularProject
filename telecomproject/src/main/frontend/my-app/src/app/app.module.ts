import { HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './_components/login/login.component';

import { LoginService } from './_services/login.service';
import { SignupComponent } from './_components/signup/signup.component';
import { CookieService } from 'ngx-cookie-service';
import { ProfileComponent } from './_components/profile/profile.component';
import { HomeComponent } from './_components/home/home.component';
import { UserPlansComponent } from './_components/user-plans/user-plans.component';
import { PlansComponent } from './_components/plans/plans.component';
import { ListComponent } from './_components/list/list.component';
import { EditComponent } from './_components/edit/edit.component';
import { UserInfoComponent } from './_components/user-info/user-info.component';


@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ProfileComponent,
    HomeComponent,
    UserPlansComponent,
    PlansComponent,
    ListComponent,
    EditComponent,
    UserInfoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [LoginService, CookieService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
