/**
 * Created by Archontellis on 14/4/2017.
 */
import { Route } from '@angular/router';

import { UserListComponent } from './userList.component';
// import { AuthGuard } from '../../guards/index';

export const UserListRoutes: Route[] = [
  {
    path: 'all',
    component: UserListComponent
  }
];
