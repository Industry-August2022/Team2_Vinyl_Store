import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import { first } from 'rxjs';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: any;
  users: any[] = [];

  constructor(
    private router:Router,
    private authService: AuthenticationService,
    private userService: UserService
  ){
    this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }


  deleteUser(id:number){
    this.userService.delete(id)
    .pipe(first())
    .subscribe(() => this.loadAllUsers());
  }

  private loadAllUsers() {
    this.userService.getAllUsers()
    .pipe(first())
    .subscribe(users => this.users = users);
  }

  ngOnInit(): void {
    this.loadAllUsers();
  
  }

}
