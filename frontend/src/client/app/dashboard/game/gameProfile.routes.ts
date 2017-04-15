import { Route } from '@angular/router';
import {GameProfileComponent} from './gameProfile.component';

export const GameProfileRoutes: Route[] = [
  {
    path: 'view/:id',
    component: GameProfileComponent
  }
];
