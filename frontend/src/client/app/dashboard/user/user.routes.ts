import { Route } from '@angular/router';

import { UserProfileRoutes } from './userProfile.routes';
import { UserEditRoutes } from './userEdit.routes';
import { UserListRoutes } from './userList.routes';
import { UserSearchRoutes } from './userSearch.routes';

import { UserComponent } from './index';
import {UserWalletRoutes} from './userWallet.routes';

export const UserRoutes: Route[] = [
  	{
    	path: 'users',
    	component: UserComponent,
    	children: [
        ...UserProfileRoutes,
        ...UserEditRoutes,
        ...UserListRoutes,
        ...UserSearchRoutes,
        ...UserWalletRoutes
    	]
  	}
];
