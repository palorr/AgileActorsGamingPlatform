import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { CONFIGURATION } from '../shared/app.constants';

@Injectable()
export class GameService {

  constructor(private http: Http) { }

  getAllGames() {
    let allGamesURL = CONFIGURATION.agileUrls.webApi+'games';

    let headers = new Headers({
      'Accept':'application/json',
    });
    let options = new RequestOptions({ headers: headers });

    return this.http.get(allGamesURL, options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }
  getGameMainInfo(gameId: number) {
    let userURL = CONFIGURATION.agileUrls.webApi+'games/' + gameId;

    let headers = new Headers({
      'Accept': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });


    return this.http.get(userURL, options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }




}
