import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { GenericUser } from '../models/index';

import { CONFIGURATION } from '../shared/app.constants';

@Injectable()
export class UserService {

    constructor(private http: Http) { }

    getAllUsers() {
        let allUsersURL = CONFIGURATION.agileUrls.webApi+'users';

        let headers = new Headers({
            'Accept': 'application/json'
        });

        let options = new RequestOptions({ headers: headers });

        return this.http.get(allUsersURL, options)
            .map((response: Response) => response.json())
            .catch(res => {
                console.log('CATCH: ', res.json());
                throw (res.json());
            });

    }
    getAllUsersByName(searchTerm: string) {
        let URL = CONFIGURATION.agileUrls.webApi+'users/search/' + searchTerm;

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

    getUserMainInfo(userId: number) {

        let userURL = CONFIGURATION.agileUrls.webApi+'users/' + userId;

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

    getCurrentUserInfo() {
        let url = CONFIGURATION.agileUrls.webApi+'users/getCurrentUserInfo';

        let options = CONFIGURATION.jwt();

        return this.http.get(url, options)
            .map((response: Response) => response.json())
            .catch(res => {
                console.log('CATCH: ', res.json());
                throw (res.json());
            });
    }

    updateUser(user: GenericUser) {
        let editUserURL = CONFIGURATION.agileUrls.webApi+'users/edit';

        let headers = new Headers({
          'Content-Type': 'application/json',
        });

         let options = new RequestOptions({ headers: headers });

         let putRequestBody = JSON.stringify(user);

         return this.http.put(editUserURL, putRequestBody, options)
             .map((response: Response) => response)
             .catch(res => {
                 console.log('CATCH: ', res.json());
                 throw (res.json());
             });
     }

  // isRequestorThisUser(Username: string) {
  //     if (localStorage.getItem('currentUser').includes(Username)) {
  //         return true;
  //     }
  //     return false;
  // }
}
