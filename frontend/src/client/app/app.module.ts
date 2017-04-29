import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { routes } from './app.routes';

import { LoginModule } from './login/login.module';
import { SignupModule } from './signup/signup.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { SharedModule } from './shared/shared.module';

import {
	AlertService,
	AuthenticationService,
	RegistrationService,
	UserService,
  GameService,
  WalletService,
  HomeService
} from './services/index';

import { AuthGuard } from './guards/index';

@NgModule({
	imports: [
		BrowserModule,
		HttpModule,
		RouterModule.forRoot(routes),
		FormsModule,
		LoginModule,
		SignupModule,
		DashboardModule,
		SharedModule.forRoot()
	],
	declarations: [
		AppComponent
	],
	providers: [
		{
			provide: APP_BASE_HREF,
			useValue: '<%= APP_BASE %>'
		},
		AlertService,
    AuthenticationService,
		RegistrationService,
		UserService,
		GameService,
		AuthGuard,
    WalletService,
    HomeService
	],
	bootstrap: [AppComponent]

})

export class AppModule { }
