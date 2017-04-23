import { Route } from '@angular/router';
import {WalletProfileComponent} from './walletProfile.component';



export const WalletProfileRoutes: Route[] = [
  {
    path: 'view/:id',
    component: WalletProfileComponent
  }
];
