import { Route } from '@angular/router';

import { GameListComponent } from './gameList.component';
// import { AuthGuard } from '../../guards/index';

export const GameListRoutes: Route[] = [
  {
    path: 'all',
    component: GameListComponent
  }
];
