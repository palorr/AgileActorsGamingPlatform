import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { WalletService, AlertService } from '../../services/index';

import { WithdrawResponse } from '../../models/index';


@Component({
  moduleId: module.id,
  selector: 'wallet-withdraw-cmp',
  templateUrl: './walletWithdraw.component.html'
})

export class WalletWithdrawComponent implements OnInit {

  id: number;
  IBAN: string ;
  creditsToWithdraw: string ;
  withdrawResponse: WithdrawResponse;
  loading = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private walletService: WalletService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.id = +params['id']; // export id from url path

    });
  }

  withdraw() {

    this.loading = true ;

    if(!this.validateIBAN(this.IBAN)) {
      this.alertService.error('Invalid IBAN format.');
      this.loading = false;
      return;
    }

    if(!this.validateCreditsAmount(this.creditsToWithdraw)) {
      this.alertService.error('Credits amount is not valid.');
      this.loading = false;
      return;
    }

    this.walletService.withdraw(this.id, this.IBAN, +this.creditsToWithdraw)
      .subscribe(
        (data: WithdrawResponse) => {

          this.withdrawResponse = data;
          console.log('Withdraw Response: ', this.withdrawResponse);
          this.loading = false;

          if(this.withdrawResponse.success) {

            if(this.withdrawResponse.overLimit) {

              if(this.withdrawResponse.hasEnoughCredits) {

                this.loading = false ;
                this.alertService.success('Congratulations. You have successfully made a withdraw of '+
                  this.withdrawResponse.credits+' credits');

              }else {
                this.loading = false ;
                this.alertService.error('You dont have enough credits to make a withdrawal');
              }
            }else {
              this.loading = false ;
              this.alertService.error('You must make a withdraw above 30 credits');
            }
          }else {
            this.loading = false ;
            this.alertService.error('This IBAN does not exist');
          }

        },
        (err) => {
          this.loading = false;
          this.alertService.error('I am sorry, something went wrong. Please try again later!');
        }
      );
  }

  validateIBAN ( iban: string) {
    var reg = /^(GR)[0-9]{32}$/; // starts with GR and 32 numbers after that
    return reg.test(iban);
  }

  validateCreditsAmount( credits: string) {
    var reg = /^[0-9]{1,3}$/; // max number 999- min 1
    return reg.test(credits);
  }
}
