import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map' ;

import { CONFIGURATION } from '../shared/app.constants';

@Injectable()
export class RegistrationService {
    constructor(private http: Http) { }

    registerUser(username: string, name: string, surname: string, password: string, confirmedPassword: string) {

        let registerURL = CONFIGURATION.agileUrls.webApi+'register';

        let headers = new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        });

        let postRequestBody = JSON.stringify({
      			username: username,
            name: name,
            surname: surname,
            password: password,
            confirmedPassword: confirmedPassword
		    });

        let options = new RequestOptions({ headers: headers });

        return this.http.post(registerURL, postRequestBody, options)
            .map((response: Response) => response.json())
            .catch(res => {
                console.log('CATCH: ', res.json());
                throw(res.json());
            });
    }

}
