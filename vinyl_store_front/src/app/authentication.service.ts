import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

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
     return this.http.post<any>(`http://localhost:4200/users/authenticate`, {username, password})
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
}
