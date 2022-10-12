import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../api-classes/cart';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  carts !: Cart[];
  cart !: Cart;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addCart(cart : Cart) : boolean{
    this.httpClient.post<Cart>(apiUrl+"cart", cart, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllCart(): Observable<Cart[]>{
    return this.httpClient.get<Cart[]>(apiUrl+"cart")
      .pipe(
        map(response => {
          this.carts = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getCartById(cartId: number) : Observable<Cart>{
    return this.httpClient.get<Cart>(apiUrl+"cart/" +cartId)
      .pipe(
        map(response => {
          this.cart = response;
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
