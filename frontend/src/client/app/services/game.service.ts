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

  getAllGamesByName(searchTerm: string) {
    let URL = CONFIGURATION.agileUrls.webApi+'games/search/' + searchTerm;

    let headers = new Headers({
      'Accept': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });

    return this.http.get(URL, options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }

  playGame(gameId: number ,userId: number) {

    let playGameURL = CONFIGURATION.agileUrls.webApi+'games/play';

    let headers = new Headers({
      'Content-Type': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });

    let postRequestBody = JSON.stringify({
      userId: userId,
      gameId: gameId
    });

    return this.http.post(playGameURL, postRequestBody, options)
      .map((response: Response) => response.json() )
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }

  tryGame(gameId: number ,userId: number) {

    let tryGameURL = CONFIGURATION.agileUrls.webApi+'games/try';

    let headers = new Headers({
      'Content-Type': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });

    let postRequestBody = JSON.stringify({
      userId: userId,
      gameId: gameId
    });

    return this.http.post(tryGameURL, postRequestBody, options)
      .map((response: Response) => response.json() )
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }

}
