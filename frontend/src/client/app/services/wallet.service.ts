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

}
