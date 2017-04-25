import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AlertModule } from '../../directives/alert.module';

// import wallet components hera
import {WalletComponent} from './wallet.component';
import {WalletProfileComponent} from './walletProfile.component';
import {WalletDepositComponent} from './walletDeposit.component';
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
    WalletDepositComponent
  ],
  exports: [
    WalletComponent,
    WalletProfileComponent,
    WalletDepositComponent
  ]
})


export class WalletModule { }
