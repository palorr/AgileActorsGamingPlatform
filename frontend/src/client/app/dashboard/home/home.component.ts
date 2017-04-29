import { Component, OnInit , Input } from '@angular/core';
import { HomeService, AlertService } from '../../services/index';
import { WonGameResponse,GenericGame } from '../../models/index';
import { AuthGuard } from '../../guards/auth.guard';

  @Component({
    moduleId: module.id,
    selector: 'home-cmp',
    templateUrl: 'home.component.html'
  })

  export class HomeComponent implements OnInit {

    @Input() wonGames: WonGameResponse[] = [];
    @Input() trendingGames: GenericGame[] = [];
    homeIntervals: Array<any> = [];

    constructor(
      private alertService: AlertService,
      private authGuard: AuthGuard,
      private homeService: HomeService
    ) { }

    ngOnInit() {
      //first get
      this.homeService
        .getLastTenWins()
        .subscribe(
          (data: WonGameResponse[]) => {
            this.wonGames = data;
            console.log('Last 10 won games', this.wonGames);
          },
          (err: any) => {
            alert(err);
          }
        );

      this.homeService
        .getTopTwoTrendingGames()
        .subscribe(
          (data: GenericGame[]) => {
            this.trendingGames = data;
            console.log('Top two trending games', this.trendingGames);
          },
          (err: any) => {
            alert(err);
          }
        );
      // //set interval for auto refresh
      // this.homeIntervals.push(
      //   window.setInterval(function () {
      //
      //     this.homeService
      //       .getLastTenWins()
      //       .subscribe(
      //         (data: WonGameResponse[]) => {
      //           this.wonGames = data;
      //           console.log('Last 10 won games', this.wonGames);
      //         },
      //         (err: any) => {
      //           alert(err);
      //         }
      //       );
      //
      //   }, 3000)
      // );


    }

    // ngOnDestroy() {
    //     for (let i = 0; i < this.homeIntervals.length; i++) {
    //       console.log('clear home interval no', i);
    //       window.clearInterval(this.homeIntervals[i]);
    //     }
    // }

  }
