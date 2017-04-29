import { NgModule } from '@angular/core';

import { AlertModule } from '../../directives/alert.module';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';

@NgModule({
    imports: [
      CommonModule,
      RouterModule,
      AlertModule
    ],
    declarations: [HomeComponent],
    exports: [HomeComponent]
})

export class HomeModule { }
