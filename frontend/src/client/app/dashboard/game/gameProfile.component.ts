import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { GameService, AlertService } from '../../services/index';
import { GenericGame , PlayResponse } from '../../models/index';
import { TryResponse } from '../../models/tryResponse';
import { UserService } from '../../services/user.service';
import { AuthGuard } from '../../guards/auth.guard';

@Component({
  moduleId: module.id,
  selector: 'game-profile-cmp',
  templateUrl: 'gameProfile.component.html'
})

export class GameProfileComponent implements OnInit {

  id : string ;
  game : GenericGame ;
  playResponse: PlayResponse ;
  tryResponse: TryResponse ;
  hasEnoughTries: boolean ;
  moreTries: number ;
  loading = false ;
  isRequesterLoggedIn: boolean = false ;

  constructor(
    private route: ActivatedRoute,
    private gameService: GameService,
    private alertService: AlertService,
    private guard: AuthGuard,
    private userService: UserService
  ) { }

  ngOnInit() {

    this.route.params.forEach((params: Params) => {
      this.id = params['id'];

      this.isRequesterLoggedIn = this.guard.isUserLoggedIn();

      this.gameService.getGameMainInfo(+this.id)
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

    if(this.isRequesterLoggedIn) {

      this.loading = true;
      this.playResponse = null;//hide the results
      this.tryResponse = null;

      this.gameService
        .playGame(+this.id, this.userService.getCurrentUserId())
        .subscribe(
          (data: PlayResponse) => {
            this.playResponse = data;
            this.loading = false;
            console.log('Game Result: ', this.playResponse);
          },

          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');

          });
    } else {
      this.alertService.error('I am sorry, you have to login first!');
    }

  }

  tryGame() {

    if(this.isRequesterLoggedIn) {

      this.loading = true;
      this.playResponse = null;//hide the results
      this.tryResponse = null;

      this.gameService
        .tryGame(+this.id, this.userService.getCurrentUserId())
        .subscribe(
          (data: TryResponse) => {
            this.tryResponse = data;

            if (this.tryResponse.currentTryNumber === 0) {
              this.hasEnoughTries = false;
            } else {
              this.hasEnoughTries = true;
              this.moreTries = 3 - this.tryResponse.currentTryNumber;
            }

            this.loading = false;
            console.log('Try Result: ', this.tryResponse);
          },

          (err) => {
            this.alertService.error('I am sorry, something went wrong. Please try again later!');

          });

    } else {
      this.alertService.error('I am sorry, you have to login first!');
    }
  }
}
