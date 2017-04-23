import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import {CONFIGURATION} from '../shared/app.constants';

@Injectable()
export class WalletService {

  constructor(private http: Http) { }

  getWalletByUserId(userId : number) {

    let URL = CONFIGURATION.agileUrls.webApi+'wallet/'+userId ;

    let headers = new Headers({
      'Accept': 'application/json'
    });

    let options = new RequestOptions({
      headers: headers
    });

    return this.http.get(URL , options)
      .map((response: Response) => response.json())
      .catch(res => {
        console.log('CATCH: ',res.json());
        throw (res.json());
      });

  }

  deposit(userId : number , number : string , credits : number) {

    let depositURL = CONFIGURATION.agileUrls.webApi+'wallet/deposit';

    let headers = new Headers({
      'Content-Type': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });

    let postRequestBody = JSON.stringify({
      userId: userId,
      number: number,
      credits: credits
    });

    return this.http.post(depositURL, postRequestBody, options)
      .map((response: Response) => response.json() )
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });

  }

  withdraw(userId: number , number : string , credits : number) {

    let withdrawalURL = CONFIGURATION.agileUrls.webApi+'wallet/withdraw';

    let headers = new Headers({
      'Content-Type': 'application/json',
    });

    let options = new RequestOptions({ headers: headers });

    let postRequestBody = JSON.stringify({
      userId: userId,
      number: number,
      credits: credits
    });

    return this.http.post(withdrawalURL, postRequestBody, options)
      .map((response: Response) => response.json() )
      .catch(res => {
        console.log('CATCH: ', res.json());
        throw (res.json());
      });
  }
}
