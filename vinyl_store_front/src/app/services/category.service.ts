import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../api-classes/category';
import { catchError, map } from 'rxjs/operators';
import { apiUrl } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categorys !: Category[];
  category !: Category;

  postHeader = {headers: new HttpHeaders({
    'Content-Type' : 'application/json'
  })};


  constructor(private httpClient: HttpClient) { }

  addCategory(category : Category) : boolean{
    this.httpClient.post<Category>(apiUrl+"category", category, this.postHeader)
      .subscribe(response => {}, (err) => {console.log(err);
      });
      return true;
  }

  getAllCategorys(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(apiUrl+"category")
      .pipe(
        map(response => {
          this.categorys = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getCategoryById(categoryId: number) : Observable<Category>{
    return this.httpClient.get<Category>(apiUrl+"category/" +categoryId)
      .pipe(
        map(response => {
          this.category = response;
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
