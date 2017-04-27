import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { CONFIGURATION } from '../shared/app.constants';

@Injectable()
export class AuthenticationService {

    constructor(private http: Http) { }

    login(username: string, password: string) {

        let loginURL = CONFIGURATION.agileUrls+'oauth2/token';

        let headers = new Headers({
          'Content-Type': 'application/json',
        });

        let postRequestBody = JSON.stringify({
          username: username,
          password: password
        });

        let options = new RequestOptions({ headers: headers });

        return this.http.post(loginURL, postRequestBody, options)
            .map((response: Response) => {

                console.log('Response: ', response.json());

                let id = response.json();

                if ( id ) {

                    let userDetails = {
                        'id': id ,
                        'username': username
                    };

                    localStorage.setItem('currentUser', JSON.stringify(userDetails));
                }
            })
            .catch(res => {
                console.log('CATCH: ', res.json());
                throw(res.json());
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}
