import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient){}

  getAllUsers(){
    return this.http.get<any[]>(`http://localhost:4200/users`);
  }

  register(user: any){
    return this.http.post(`http://localhost:4200/users/register`, user);
  }
  
  delete(id: any){
    return this.http.delete(`http://localhost:4200/users/${id}`);
  }

}
