import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../api-classes/user';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  users !: User[];
  user !: User;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addUser(user : User) : boolean{
    this.httpClient.post<User>(apiUrl+"user", user, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(apiUrl+"user")
      .pipe(
        map(response => {
          this.users = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getUserById(userId: number) : Observable<User>{
    return this.httpClient.get<User>(apiUrl+"user/" +userId)
      .pipe(
        map(response => {
          this.user = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  handleError<T>(): any {
    return (error: any): Observable<T> => {
      console.log("error");
      return error;
    }
  }
}
