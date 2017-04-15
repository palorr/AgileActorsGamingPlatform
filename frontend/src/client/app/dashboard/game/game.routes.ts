import { Route } from '@angular/router';

import { GameProfileRoutes } from './gameProfile.routes';
import { GameListRoutes } from './gameList.routes';

import { GameComponent } from './index';
import {GameSearchRoutes} from './gameSearch.routes';

export const GameRoutes: Route[] = [
  {
    path: 'games',
    component: GameComponent,
    children: [
      ...GameProfileRoutes,
      ...GameListRoutes,
      ...GameSearchRoutes
    ]
  }
];
