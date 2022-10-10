import { Injectable } from "@angular/core";
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS} from '@angular/common/http';
import { merge, Observable, of, throwError } from "rxjs";
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';
import { registerLocaleData } from "@angular/common";


let dummyUsers = JSON.parse(localStorage.getItem('users')!) || [];

@Injectable()
export class TempBackendInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const { url, method, headers, body } = request;

        return of (null)
            .pipe(mergeMap(routeHandler))
            .pipe(materialize())
            .pipe(delay(500)) //delays despite any errors
            .pipe(dematerialize());

        function routeHandler(){
            if(url.endsWith('/users/authenticate') && method === 'POST'){
                return authenticate();
            }else if (url.endsWith('/users/register') && method === 'POST'){
                return register();
            }
            return next.handle(request);
        }

        function authenticate(){
            const { username, password } = body;
            //match the entered information with the information in the mock DB 
            const currentUser = dummyUsers.find((e: { email: any; password: any; }) => e.email === username && e.password === password);

            //if we can't find a match
            if(!currentUser){
                return error('Email or password is incorrect');
            }

            return OK({
                userId: currentUser.userId,
                fullName: currentUser.fullName,
                email: currentUser.email,
                password: currentUser.password
            });
        }//authenticate()

        function register(){
            const user = body;

            if(dummyUsers.find((x: { email: any; }) => x.email === dummyUsers.email)){
                return error('Email address "' + user.email + '" is already registered.');
            }

            user.userId = dummyUsers.length ? Math.max(...dummyUsers.map((x: { userId: any; }) => x.userId)) + 1: 1;
            dummyUsers.push(user);
            localStorage.setItem('dummyUsers', JSON.stringify(dummyUsers));

            return OK();
        }
        function OK(body?: { userId: number; fullName: string; email: string; password: string; }){
            return of (new HttpResponse({ status: 200, body}));
        }

        //Can't pass with Error, so I will make this function to throw our own error
        function error(text: string){
            return throwError({ error: {text}});
        }
        
    }
}
export const tempBackendProvider = {
    provide: HTTP_INTERCEPTORS,
    useClass: TempBackendInterceptor,
    multi:true
};