import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';
import { AlertModule } from '../directives/alert.module';

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        FormsModule,
        AlertModule
    ],
    declarations: [LoginComponent],
    exports: [LoginComponent]
})

export class LoginModule { }
