import { Route } from '@angular/router';

import { GameProfileRoutes } from './gameProfile.routes';

import { GameComponent } from './index';

export const GameRoutes: Route[] = [
  {
    path: 'games',
    component: GameComponent,
    children: [
      ...GameProfileRoutes
    ]
  }
];