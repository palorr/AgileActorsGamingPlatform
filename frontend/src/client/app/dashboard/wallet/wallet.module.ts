import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AlertModule } from '../../directives/alert.module';

// import wallet components here
import {WalletComponent} from './wallet.component';
import {WalletProfileComponent} from './walletProfile.component';
import {WalletDepositComponent} from './walletDeposit.component';
import {WalletWithdrawComponent} from './walletWithdraw.component';
// <--------------------------->

import {
  TabsModule,
} from 'ng2-bootstrap/ng2-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    TabsModule,
    AlertModule
  ],
  declarations: [
    WalletComponent,
    WalletProfileComponent,
    WalletDepositComponent,
    WalletWithdrawComponent
  ],
  exports: [
    WalletComponent,
    WalletProfileComponent,
    WalletDepositComponent,
    WalletWithdrawComponent
  ]
})


export class WalletModule { }
