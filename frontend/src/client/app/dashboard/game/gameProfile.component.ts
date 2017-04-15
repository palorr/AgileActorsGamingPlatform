import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { GameService, AlertService } from '../../services/index';

import { GenericGame } from '../../models/index';

@Component({
  moduleId: module.id,
  selector: 'gameProfile-cmp',
  templateUrl: 'gameProfile.component.html'
})

export class GameProfileComponent implements OnInit {
  id : number ;
  game : GenericGame ;

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
}
