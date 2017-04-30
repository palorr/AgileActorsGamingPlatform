import { Route } from '@angular/router';
import { UserEditComponent } from './userEdit.component';

export const UserEditRoutes: Route[] = [
  {
    path: 'edit/:id',
    component: UserEditComponent
  }
];
