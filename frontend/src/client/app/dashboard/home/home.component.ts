import { Component, OnInit , OnDestroy } from '@angular/core';
import { HomeService, AlertService } from '../../services/index';
import { WonGameResponse } from '../../models/index';
import { AuthGuard } from '../../guards/auth.guard';

  @Component({
    moduleId: module.id,
    selector: 'home-cmp',
    templateUrl: 'home.component.html'
  })

  export class HomeComponent implements OnInit, OnDestroy {

    wonGames: WonGameResponse[] = null;
    homeIntervals: Array<any> = [];

    constructor(
      private alertService: AlertService,
      private authGuard: AuthGuard,
      private homeService: HomeService
    ) { }

    ngOnInit() {

      this.homeIntervals.push(
        window.setInterval(function () {
          this.homeService
            .getLastTenWins()
            .subscribe(
              (data: WonGameResponse[]) => {
                this.wonGames = data;
                console.log('Last 10 won games', this.wonedGames);
              },
              (err: any) => {
                alert(err);
              }
            );
        }, 10000)
      );


    }

    ngOnDestroy() {
        for (let i = 0; i < this.homeIntervals.length; i++) {
          console.log('clear home interval no', i);
          window.clearInterval(this.homeIntervals[i]);
        }
    }

  }
