import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { GameService, AlertService } from '../../services/index';

import { GenericGame , PlayResponse } from '../../models/index';
import {TryResponse} from "../../models/tryResponse";

@Component({
  moduleId: module.id,
  selector: 'game-profile-cmp',
  templateUrl: 'gameProfile.component.html'
})

export class GameProfileComponent implements OnInit {
  id : number ;
  game : GenericGame ;
  playResponse: PlayResponse ;
  tryResponse: TryResponse ;
  hasEnoughTries: boolean ;
  moreTries: number ;
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
      this.playResponse = null;//hde the results
      this.tryResponse = null;

      return this.gameService
        .playGame(this.id , 1)//fake -> user 1 is playing, i need token to take the current user
        .subscribe(

          (data: PlayResponse) => {
            this.playResponse = data ;
            this.loading = false ;
            console.log('Game Result: ', this.playResponse) ;
          },

          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');

          });
  }

  tryGame() {

    this.loading = true ;
    this.playResponse = null;//hide the results
    this.tryResponse = null;

    return this.gameService
      .tryGame(this.id , 1)//fake -> user 1 is tryig, i need token to take the current user
      .subscribe(

        (data: TryResponse) => {
          this.tryResponse = data ;

          if(this.tryResponse.currentTryNumber===0) {
            this.hasEnoughTries = false ;
          } else {
            this.hasEnoughTries = true ;
            this.moreTries = 3 - this.tryResponse.currentTryNumber ;
          }

          this.loading = false ;
          console.log('Try Result: ', this.tryResponse) ;
        },

        (err) => {
          this.alertService.error('I am sorry, something went wrong. Please try again later!');

        });
  }
}
