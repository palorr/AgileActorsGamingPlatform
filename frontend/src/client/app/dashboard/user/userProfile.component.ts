import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { UserService, AlertService } from '../../services/index';

import { GenericUser } from '../../models/index';
import {AuthGuard} from '../../guards/auth.guard';


@Component({
	moduleId: module.id,
	selector: 'user-profile-cmp',
	templateUrl: 'userProfile.component.html'
})

export class UserProfileComponent implements OnInit {
  id: string;
	user: GenericUser;
	isRequesterLoggedIn: boolean = false;
	isRequesterThisUser: boolean = false;

	constructor(
		private route: ActivatedRoute,
		private router: Router,
		private userService: UserService,
		private guard: AuthGuard,
		private alertService: AlertService
	) { }

	ngOnInit() {
		console.log('THIS>ROUTES>PARAMS: ', this.route.params);
		this.route.params.forEach((params: Params) => {
			this.id = params['id'];

			this.isRequesterLoggedIn = this.guard.isUserLoggedIn();
      this.isRequesterThisUser = this.userService.isRequesterThisUser(this.id);


      if (this.isRequesterLoggedIn ) {
        this.userService.getUserMainInfo(+this.id)
          .subscribe(
            (data: GenericUser) => {
              this.user = data;
              console.log('User Profile View Data: ', this.user);
            },
            (err) => {
              this.alertService.error('I am sorry, something went wrong. Please try again later!');
            }
          );
      }


		});
	}
}
