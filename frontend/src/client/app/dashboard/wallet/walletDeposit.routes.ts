import { Route } from '@angular/router';

import { WalletDepositComponent } from './walletDeposit.component';

export const WalletDepositRoutes: Route[] = [
  {
    path: 'deposit/:id',
    component: WalletDepositComponent
  }
];
