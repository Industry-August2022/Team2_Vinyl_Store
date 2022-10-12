import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderInfo } from '../api-classes/order-info';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class OrderInfoService {

  orderInfos !: OrderInfo[];
  orderInfo !: OrderInfo;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addOrderInfo(orderInfo : OrderInfo) : boolean{
    this.httpClient.post<OrderInfo>(apiUrl+"order_info", orderInfo, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllOrderInfo(): Observable<OrderInfo[]>{
    return this.httpClient.get<OrderInfo[]>(apiUrl+"order_info")
      .pipe(
        map(response => {
          this.orderInfos = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getOrderInfoById(orderInfoId: number) : Observable<OrderInfo>{
    return this.httpClient.get<OrderInfo>(apiUrl+"order_info/" +orderInfoId)
      .pipe(
        map(response => {
          this.orderInfo = response;
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
