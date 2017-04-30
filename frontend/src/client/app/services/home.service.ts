import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { CONFIGURATION } from '../shared/app.constants';

@Injectable()
export class HomeService {

  constructor(private http: Http) { }

  getLastTenWins() {
    let lastTenWinsUrl = CONFIGURATION.agileUrls.webApi+'home/lastTenWinGames';

    let headers = new Headers({
      'Accept':'application/json',
    });
    let options = new RequestOptions({ headers: headers });

    return this.http.get(lastTenWinsUrl, options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }

  getTopTwoTrendingGames() {
    let mostTrendingUrl = CONFIGURATION.agileUrls.webApi+'home/mostTrendingGames';

    let headers = new Headers({
      'Accept':'application/json',
    });
    let options = new RequestOptions({ headers: headers });

    return this.http.get(mostTrendingUrl, options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }
}
