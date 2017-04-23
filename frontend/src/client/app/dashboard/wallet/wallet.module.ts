import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

// import wallet components hera
import {WalletComponent} from './wallet.component';
import {WalletProfileComponent} from './walletProfile.component';
// <--------------------------->

import {
  TabsModule,
} from 'ng2-bootstrap/ng2-bootstrap';



@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    TabsModule
  ],
  declarations: [
    WalletComponent,
    WalletProfileComponent
  ],
  exports: [
    WalletComponent,
    WalletProfileComponent
  ]
})


export class WalletModule { }
