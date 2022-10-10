import { Injectable } from "@angular/core";
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS} from '@angular/common/http';
import { merge, Observable, of, throwError } from "rxjs";
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';

let dummyUsers = [{userId: 1, fullName: 'Destiny Simms', email: 'test', password: 'test'}];

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
            }
            return next.handle(request);
        }

        function authenticate(){
            const { username, password } = body;
            //match the entered information with the information in the mock DB 
            const currentUser = dummyUsers.find(e => e.email === username && e.password === password);

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