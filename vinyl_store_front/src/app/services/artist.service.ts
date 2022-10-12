import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artist } from '../api-classes/artist';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  artists !: Artist[];
  artist !: Artist;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addArtist(artist : Artist) : boolean{
    this.httpClient.post<Artist>(apiUrl+"artist", artist, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllArtists(): Observable<Artist[]>{
    return this.httpClient.get<Artist[]>(apiUrl+"artist")
      .pipe(
        map(response => {
          this.artists = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getArtistById(artistId: number) : Observable<Artist>{
    return this.httpClient.get<Artist>(apiUrl+"artist/" +artistId)
      .pipe(
        map(response => {
          this.artist = response;
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
