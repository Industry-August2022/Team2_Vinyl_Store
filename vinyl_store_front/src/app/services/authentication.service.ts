import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
import { RegisterHolder } from '../api-classes/auth/register-holder';
import { LoginResponse } from '../api-classes/auth/login-response';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  constructor(private http: HttpClient) {
    //it's angry at the early call so add a exclamation
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('currentUser')!));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(){
    return this.currentUserSubject.value;
  }

  login(username: any, password: any){
    return this.http.post<any>(apiUrl + "auth/login", {username, password})
    .pipe(map(user => {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.currentUserSubject.next(user);
      return user;
    }));
  }//login

  logout(){
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  register(registerData: RegisterHolder) : Observable<RegisterHolder> {
    return this.http.post(apiUrl + "auth/register", registerData)
      .pipe(map(response => {}
      ), catchError(this.handleError<any>())
    );
  }

  handleError<T>(): any {
    return (error: any): Observable<T> => {
      console.log(error);
      return error;
    }
  }
}
