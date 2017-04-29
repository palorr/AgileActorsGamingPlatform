import { Headers, RequestOptions } from '@angular/http';

export let CONFIGURATION = {

    agileUrls:{
        webApi: 'http://localhost:8081/rest/'
    },

    jwt: function() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));

        if (currentUser && currentUser.user.access_token) {

            let headers = new Headers({
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + currentUser.user.access_token
            });

            return new RequestOptions({ headers: headers });
        } else {
            return new RequestOptions({});
        }
    }
};
