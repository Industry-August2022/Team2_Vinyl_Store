import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../api-classes/cart';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
import { OrderInfo } from '../api-classes/order-info';
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

  addCart(cart : Cart) : Observable<Cart>{
    return this.httpClient.post<Cart>(apiUrl+"cart", cart, this.postHeader)
      .pipe(
        map(response => {
          return response;
        }),
        catchError(this.handleError<any>())
        );
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

  getCartByUserId(userId: number) : Observable<Cart> {
    console.log("User ID: " + userId);
    return this.httpClient.get<Cart>(apiUrl+"cart/user/" +userId)
      .pipe(
        map(response => {
          this.cart = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  checkoutUser(userId: number) : Observable<OrderInfo> {
    return this.httpClient.get<OrderInfo>(apiUrl+"cart/checkout/"+userId)
      .pipe(
        map(response => {
          return response;
        }),
        catchError(this.handleError<any>())
      )
  }

  handleError<T>(): any {
    return (error: any): Observable<T> => {
      console.log(error);
      return error;
    }
  }
}
