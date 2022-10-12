import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderEntry } from '../api-classes/order-entry';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class OrderEntryService {

  orderEntrys !: OrderEntry[];
  orderEntry !: OrderEntry;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addOrderEntry(orderEntry : OrderEntry) : boolean{
    this.httpClient.post<OrderEntry>(apiUrl+"order-entry", orderEntry, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllOrderEntry(): Observable<OrderEntry[]>{
    return this.httpClient.get<OrderEntry[]>(apiUrl+"order-entry")
      .pipe(
        map(response => {
          this.orderEntrys = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getOrderEntryById(orderEntryId: number) : Observable<OrderEntry>{
    return this.httpClient.get<OrderEntry>(apiUrl+"order-entry/" +orderEntryId)
      .pipe(
        map(response => {
          this.orderEntry = response;
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
