import { Injectable } from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor} from '@angular/common/http';
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs";
import { AuthenticationService } from "./services/authentication.service";

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(private authService: AuthenticationService){}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => { 
            if(err.status === 401){
                 //kick out unauth users that trigger a 401
                this.authService.logout();
                location.reload();
            }

            const error = err.error.text || err.statusText;
            return throwError(error);
           
        }))
    }
}