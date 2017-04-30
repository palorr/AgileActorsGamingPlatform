import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AlertService, RegistrationService } from '../services/index';
import { User } from '../models/user';
import { RegisterResponse } from '../models/index';


@Component({
	moduleId: module.id,
	selector: 'signup-cmp',
	templateUrl: 'signup.component.html'
})

export class SignupComponent {

	user: User = new User();
  registerResponse:  RegisterResponse;
	loading = false;

    constructor(
        private router: Router,
        private alertService: AlertService,
        private registrationService: RegistrationService
    ) { }

    registerUser() {
        this.loading = true;

        if(!this.validateUsername(this.user.username)) {
            this.alertService.error('Username must have 5 minimum length !!!');
			      this.loading = false;
			      return;
        }

        if(this.user.password !== this.user.repeatPassword) {
                this.alertService.error('Provided passwords do not match.');
          this.loading = false;
          return;
        }

		    console.log('USER TO REGISTER: ', this.user);

        this.registrationService
          .registerUser(this.user.username ,this.user.name, this.user.surname, this.user.password, this.user.repeatPassword)
            .subscribe(
                (data: RegisterResponse) => {

                  this.registerResponse = data ;

                  if(this.registerResponse.success) {

                    this.alertService.success('Registration successful! Please login now.', true);
                    this.router.navigate(['/login']);

                  } else {
                    this.loading = false ;
                    this.alertService.error('This username has already been registered. Please try again with a different one!');

                  }
                },
                (err) => {

                  this.alertService.error('Something went wrong.Please try again later!');

                  this.loading = false;

                });

    }

    validateUsername(username: string) {

        let re = /^.{5,}$/; //minlength = 5
        return re.test(username);
    }
}
