import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { GameService, AlertService } from '../../services/index';
import { GenericGame } from '../../models/index';

@Component({
  moduleId: module.id,
  selector: 'game-search-cmp',
  templateUrl: 'userSearch.component.html'
})

export class GameSearchComponent {
  games: GenericGame[];

  constructor(
    private route: ActivatedRoute,
    private gameService: GameService,
    private alertService: AlertService
  ) {}

  searchByName(searchTerm: string): any {
    if(searchTerm.length > 1) {
      return this.gameService
        .getAllGamesByName(searchTerm)
        .subscribe(
          (data: GenericGame[]) => {
            this.games = data;
            console.log('Projects Data: ', this.games);
          },
          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');
          }
        );
    }

    this.games = [];
    return;
  }
}
