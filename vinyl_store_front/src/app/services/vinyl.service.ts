import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vinyl } from '../api-classes/vinyl';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class VinylService {

  vinyls !: Vinyl[];
  vinyl !: Vinyl;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addVinyl(vinyl : Vinyl) : boolean{
    this.httpClient.post<Vinyl>(apiUrl+"vinyl", vinyl, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllVinyl(): Observable<Vinyl[]>{
    return this.httpClient.get<Vinyl[]>(apiUrl+"vinyl")
      .pipe(
        map(response => {
          this.vinyls = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getVinylById(vinylId: number) : Observable<Vinyl>{
    return this.httpClient.get<Vinyl>(apiUrl+"vinyl/" +vinylId)
      .pipe(
        map(response => {
          this.vinyl = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  handleError<T>(): any {
    return (error: any): Observable<T> => {
      console.log(error);
      return error;
    }
  }
}
