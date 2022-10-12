import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Genre } from '../api-classes/genre';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class GenreService {
  genres !: Genre[];
  genre !: Genre;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addGenre(genre : Genre) : boolean{
    this.httpClient.post<Genre>(apiUrl+"genre", genre, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllGenres(): Observable<Genre[]>{
    return this.httpClient.get<Genre[]>(apiUrl+"genre")
      .pipe(
        map(response => {
          this.genres = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getGenreById(genreId: number) : Observable<Genre>{
    return this.httpClient.get<Genre>(apiUrl+"genre/" +genreId)
      .pipe(
        map(response => {
          this.genre = response;
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
