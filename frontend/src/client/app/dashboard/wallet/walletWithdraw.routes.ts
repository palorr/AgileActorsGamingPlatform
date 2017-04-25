import { Route } from '@angular/router';

import { WalletWithdrawComponent } from './walletWithdraw.component';

export const WalletWithdrawRoutes: Route[] = [
  {
    path: 'withdraw/:id',
    component: WalletWithdrawComponent
  }
];
