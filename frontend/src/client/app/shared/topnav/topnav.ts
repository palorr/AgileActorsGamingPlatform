import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthGuard } from '../../guards/index';

import { AuthenticationService, UserService } from '../../services/index';
import { GenericUser } from '../../models/genericUser';

@Component({
	moduleId: module.id,
	selector: 'top-nav',
	templateUrl: 'topnav.html',
})

export class TopNavComponent implements OnInit {

	isLoggedIn: boolean = false;

	currentUser: GenericUser;

	intervals: any[] = [];

	constructor(
		private authGuard: AuthGuard,
		private userService: UserService,
		private authenticationService: AuthenticationService,
		private router: Router
	) { }

	ngOnInit() {

		if ( this.authGuard.canActivate() ) {//go to login page if not logged in

      this.isLoggedIn = true ;

			this.userService
				.getUserMainInfo(this.userService.getCurrentUserId())
				.subscribe(
				(data: GenericUser) => {
					this.currentUser = data;
					console.log('Current User: ', this.currentUser);
				},
				(err) => {
					console.log('ERROR: ', err);
				});
		}

	}

	logOut() {
		this.authenticationService.logout();
		this.router.navigate(['/login']);
	}

}
