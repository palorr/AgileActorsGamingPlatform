import { Route } from '@angular/router';

import { UserWalletComponent } from './userWallet.component';

export const UserWalletRoutes: Route[] = [
  {
    path: 'wallet/:id',
    component: UserWalletComponent
  }
];
