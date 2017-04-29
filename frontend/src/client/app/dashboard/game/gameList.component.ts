import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GameService } from '../../services/index';
import { GenericGame } from '../../models/index';

@Component({
  moduleId: module.id,
  selector: 'all-games-list',
  templateUrl: 'gameList.component.html'
})

export class GameListComponent implements OnInit {

  @Input() games: GenericGame[] = null;

  constructor(
    private route: ActivatedRoute,
    private gameService: GameService
  ) { }

  ngOnInit() {
    if (this.route.data && this.games===null) {
      this.gameService
        .getAllGames()
        .subscribe(
          (data: GenericGame[]) => {
            this.games = data;
            console.log('All Games Data', this.games);
          },
          (err) => {
            alert(err);
          }
        );
    }
  }

}
