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
  couponNumber: string ;
  creditsToDeposit: number ;
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

      this.walletService.deposit(this.id, this.couponNumber, this.creditsToDeposit)
        .subscribe(
          (data: DepositResponse) => {

            this.depositResponse = data;
            console.log('Deposit Response: ', this.depositResponse);

          },
          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');
          }
        );

  }




}
