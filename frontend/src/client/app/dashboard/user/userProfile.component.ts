import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { UserService, AlertService } from '../../services/index'

import { GenericUser } from '../../models/index';


@Component({
	moduleId: module.id,
	selector: 'userProfile-cmp',
	templateUrl: 'userProfile.component.html'
})

export class UserProfileComponent implements OnInit {
	
	id: number;
	user: GenericUser;
	
	isRequestorLoggedIn: boolean = false;
	isRequestorThisUser: boolean = false;

	constructor(
		private route: ActivatedRoute,
		private router: Router,
		private userService: UserService,
		private alertService: AlertService,
	) { }

	ngOnInit() {
		console.log("THIS>ROUTES>PARAMS: ", this.route.params);
		this.route.params.forEach((params: Params) => {
			this.id = +params['id'];

				this.isRequestorLoggedIn = true;
				
			//////////////////////////////
			this.userService.getUserMainInfo(this.id)
				.subscribe(
					(data: GenericUser) => {
	
						this.user = data;
						console.log('User Profile View Data: ', this.user);
						// if(this.isRequestorLoggedIn)
						// 	this.isRequestorThisUser = this.userService.isRequestorThisUser(this.user.Username);
					},
					(err) => {
						this.alertService.error('I am sorry, something went wrong. Please try again later!');
					}
				);
			



		});


	}
}
