import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { GameService, AlertService } from '../../services/index';

import { GenericGame , GameResult } from '../../models/index';

@Component({
  moduleId: module.id,
  selector: 'game-profile-cmp',
  templateUrl: 'gameProfile.component.html'
})

export class GameProfileComponent implements OnInit {
  id : number ;
  game : GenericGame ;
  gameResult: GameResult ;
  loading = false ;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private gameService: GameService,
    private alertService: AlertService,
  ) { }

  ngOnInit() {

    this.route.params.forEach((params: Params) => {
      this.id = +params['id'];
      this.gameService.getGameMainInfo(this.id)
        .subscribe(
          (data: GenericGame) => {
            this.game = data;
            console.log('Game Profile View Data: ', this.game);
          },
          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');
          }
        );
    });
  }

  playGame() {

      this.loading = true;

      return this.gameService
        .playGame(this.id , 1)//fake -> user 1 is playing, i need token to take the current user
        .subscribe(

          (data: GameResult) => {
            this.gameResult = data ;
            this.loading = false ;
            console.log('Game Result: ', this.gameResult) ;
          },

          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');

          });
  }
}
