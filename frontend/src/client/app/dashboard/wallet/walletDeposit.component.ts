import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { WalletService, AlertService } from '../../services/index';

import { DepositResponse } from '../../models/index';


@Component({
  moduleId: module.id,
  selector: 'wallet-deposit-cmp',
  templateUrl: './walletDeposit.component.html'
})

export class WalletDepositComponent implements OnInit {

  id: number;
  couponNumberToSent: string ;
  creditsToDepositToSent: string ;
  depositResponse: DepositResponse ;
  loading = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private walletService: WalletService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.id = +params['id'];


    });
  }

  deposit() {

    this.loading = true;

    if(!this.validateCouponNumber(this.couponNumberToSent)) {
      this.alertService.error('Coupon number length must be 20 digits.');
      this.loading = false;
      return;
    }

    if(!this.validateCreditsAmount(this.creditsToDepositToSent)) {
      this.alertService.error('Credits amount is not valid.');
      this.loading = false;
      return;
    }

    this.walletService.deposit(this.id, this.couponNumberToSent, +this.creditsToDepositToSent)
        .subscribe(
          (data: DepositResponse) => {

            this.depositResponse = data;
            console.log('Deposit Response: ', this.depositResponse);
            this.loading = false;

            if(this.depositResponse.success) {
              this.alertService.success('Congratulations. You have successfully made a deposit of '+
                this.depositResponse.credits+' credits');
            }else {
              this.alertService.error('This coupon number does not exist!');
            }

          },
          (err) => {
            this.loading = false;
            this.alertService.error('I am sorry, something went wrong. Please try again later!');
          }
        );

  }

  validateCouponNumber( number: string ) {
    var re = /^[0-9]{20}$/; // exactly 20 digits
    return re.test(number);
  }

  validateCreditsAmount( credits: string) {
    var re = /^[0-9]{1,3}$/; // max number 999 min 0
    return re.test(credits);
  }


}
