import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { WalletService, AlertService } from '../../services/index';
import { GenericWallet } from '../../models/index';
import { AuthGuard } from '../../guards/auth.guard';
import { UserService } from '../../services/user.service';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  moduleId: module.id,
  selector: 'wallet-profile-cmp',
  templateUrl: './walletProfile.component.html'
})

export class WalletProfileComponent implements OnInit {
  id: string;
  wallet: GenericWallet ;
  isRequesterLoggedIn: boolean = false ;
  isRequesterThisUser: boolean = false ;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private walletService: WalletService,
    private alertService: AlertService,
    private guard: AuthGuard,
    private userService: UserService,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.id = params['id'];

      this.isRequesterLoggedIn = this.guard.isUserLoggedIn();
      this.isRequesterThisUser = this.userService.isRequesterThisUser(this.id);

      if(!this.isRequesterLoggedIn || !this.isRequesterThisUser) {
        this.alertService.error('You are not authorized to see this wallet', true);
        this.authenticationService.logout();//something went wrong, remove data from local storage and go to login page
      }
      if(this.isRequesterLoggedIn && this.isRequesterThisUser) {
        this.walletService.getWalletByUserId(+this.id)
          .subscribe(
            (data: GenericWallet) => {

              this.wallet = data;
              console.log('User Wallet View Data: ', this.wallet);

            },
            (err) => {
              this.alertService.error('I am sorry, something went wrong. Please try again later!');
            }
          );
      }
    });
  }

}
