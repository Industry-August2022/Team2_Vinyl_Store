import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable } from 'rxjs';
import { Vinyl } from '../api-classes/vinyl';

import { VinylSearchRequest } from '../api-classes/vinyl-search-request';
import { apiUrl } from '../app.component';

@Injectable({
  providedIn: 'root'
})
export class SearchService {



  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};

  constructor(private httpClient: HttpClient) { }

  searchVinyl(searchRequest : VinylSearchRequest): Observable<Vinyl[]>{
    return this.httpClient.post<Vinyl[]>(apiUrl+"search/vinyl", searchRequest, this.postHeader)
      .pipe(map(
        response => {
          return response
        }
      ),
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
