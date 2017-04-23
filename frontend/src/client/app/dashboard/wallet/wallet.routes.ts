import { Route } from '@angular/router';

import { WalletComponent } from './index';

// import the component routes here
import {WalletProfileRoutes} from './walletProfile.routes';

export const WalletRoutes: Route[] = [
  {
    path: 'wallet',
    component: WalletComponent,
    children: [
      ...WalletProfileRoutes
    ]
  }
];
