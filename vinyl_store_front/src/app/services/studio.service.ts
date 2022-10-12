import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Studio } from '../api-classes/studio';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class StudioService {
  studios !: Studio[];
  studio !: Studio;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addStudio(studio : Studio) : boolean{
    this.httpClient.post<Studio>(apiUrl+"studio", studio, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllStudios(): Observable<Studio[]>{
    return this.httpClient.get<Studio[]>(apiUrl+"studio")
      .pipe(
        map(response => {
          this.studios = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getStudioById(studioId: number) : Observable<Studio>{
    return this.httpClient.get<Studio>(apiUrl+"studio/" +studioId)
      .pipe(
        map(response => {
          this.studio = response;
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
