import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent implements OnInit {

  currentUser: any;
  orderId : number = 0;

  constructor(
    private router:Router,
    private routes: ActivatedRoute,
    private authService: AuthenticationService
  ){
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.orderId = parseInt(this.routes.snapshot.paramMap.get('id')!);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
  }

}
