import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { GenericUser } from '../../models/index';
import { AlertService, UserService } from '../../services/index';
import { AuthGuard } from '../../guards/auth.guard';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  moduleId: module.id,
  selector: 'user-edit-cmp',
  templateUrl: 'userEdit.component.html'
})

export class UserEditComponent implements OnInit {
  id: string ;
  user: GenericUser = new GenericUser();
  isRequesterThisUser : boolean = false;
  isRequesterLoggedIn : boolean = false;
  loading = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private userService: UserService,
    private guard: AuthGuard,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.id = params['id'];

      this.isRequesterLoggedIn = this.guard.isUserLoggedIn();
      this.isRequesterThisUser = this.userService.isRequesterThisUser(this.id);

      if(!this.isRequesterLoggedIn || !this.isRequesterThisUser) {
        this.alertService.error('You are not authorized to edit this profile!', true);
        this.authenticationService.logout();//something went wrong, remove data from local storage and go to login page
      }
      if(this.isRequesterLoggedIn && this.isRequesterThisUser) {
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
  editUser() {
    this.loading = true;

    // console.log("User to send: ", this.user);

    this.userService.updateUser(this.user)
      .subscribe(
        (data) => {
          console.log('SUCCESS IN EDIT: ', data);
          // set success message
          this.alertService.success('User edited successfully!');
          this.loading = false;
        },
        (err) => {
          console.log('ERROR IN EDIT: ', err);
          let errorString = '';

          for(let element in err.modelState) {
            err.modelState[element].forEach((errorMsg: string) => {
              errorString += errorMsg + '\n\n';
            });
          }

          this.alertService.error('I am sorry, something went wrong. Please try again later!');
          this.loading = false;
        });
  }

}
