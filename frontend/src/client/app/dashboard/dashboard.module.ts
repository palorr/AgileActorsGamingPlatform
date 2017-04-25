import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { DropdownModule } from 'ng2-bootstrap/ng2-bootstrap';
import { ModalModule } from 'ng2-bootstrap/ng2-bootstrap';
import { BlankPageModule } from './blank-page/blankPage.module';
import { DashboardComponent } from './dashboard.component';
import {TopNavComponent} from '../shared/index';
import {SidebarComponent} from '../shared/index';
import { AlertModule } from '../directives/alert.module';

import { UserModule } from './user/user.module' ;
import { GameModule } from './game/game.module' ;
import { WalletModule } from './wallet/wallet.module' ;

@NgModule({
    imports: [
        CommonModule,
    	  RouterModule,
    	  DropdownModule,
        ModalModule,
        BlankPageModule,
        UserModule,
        GameModule,
        WalletModule,
        AlertModule
    ],
    declarations: [DashboardComponent, TopNavComponent, SidebarComponent],
    exports: [DashboardComponent, TopNavComponent, SidebarComponent]
})

export class DashboardModule { }
