import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { WalletService, AlertService } from '../../services/index';

import { GenericWallet } from '../../models/index';

@Component({
  moduleId: module.id,
  selector: 'wallet-profile-cmp',
  templateUrl: 'userWallet.component.html'
})

export class UserWalletComponent implements OnInit {
  id: number;
  wallet: GenericWallet;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private walletService: WalletService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.id = +params['id'];

      this.walletService.getWalletByUserId(this.id)
        .subscribe(
          (data: GenericWallet) => {

            this.wallet = data;
            console.log('User Wallet View Data: ', this.wallet);

            },
          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');
          }
        );
    });
  }

}
