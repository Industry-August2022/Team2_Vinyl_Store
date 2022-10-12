import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CartContent } from '../api-classes/cart-content';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class CartContentService {

  cartContents !: CartContent[];
  cartContent !: CartContent;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addCartContent(cartContent : CartContent) : boolean{
    this.httpClient.post<CartContent>(apiUrl+"cart_content", cartContent, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllCartContent(): Observable<CartContent[]>{
    return this.httpClient.get<CartContent[]>(apiUrl+"cart_content")
      .pipe(
        map(response => {
          this.cartContents = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getCartContentById(cartContentId: number) : Observable<CartContent>{
    return this.httpClient.get<CartContent>(apiUrl+"cart_content/" +cartContentId)
      .pipe(
        map(response => {
          this.cartContent = response;
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
