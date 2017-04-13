import { Route } from '@angular/router';
import { BlankPageRoutes } from './blank-page/index';
import { DashboardComponent } from './index';

import { AuthGuard } from '../guards/index';


import { UserRoutes } from './user/user.routes';


export const DashboardRoutes: Route[] = [
  	{
    	path: 'dashboard',
    	component: DashboardComponent,
    	children: [
		...UserRoutes,
        ...BlankPageRoutes
    	]
  	}
];
