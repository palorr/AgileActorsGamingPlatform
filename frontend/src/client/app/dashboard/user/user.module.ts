import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { UserProfileComponent } from './userProfile.component';
import { UserEditComponent } from './userEdit.component';
import { UserSearchComponent } from './userSearch.component';
import { UserListComponent } from './userList.component';
import { UserComponent } from './user.component';

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
        UserComponent,
        UserProfileComponent,
        UserEditComponent,
        UserListComponent,
        UserSearchComponent
    ],
    exports: [
        UserComponent,
        UserProfileComponent,
        UserEditComponent,
        UserSearchComponent,
        UserListComponent
    ]
})

export class UserModule { }
