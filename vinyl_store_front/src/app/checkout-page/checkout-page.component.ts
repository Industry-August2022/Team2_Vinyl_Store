import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../api-classes/cart';
import { Vinyl } from '../api-classes/vinyl';
import { AuthenticationService } from '../services/authentication.service';
import { CartContentService } from '../services/cart-content.service';
import { CartService } from '../services/cart.service';
import { VinylService } from '../services/vinyl.service';

@Component({
  selector: 'app-checkout-page',
  templateUrl: './checkout-page.component.html',
  styleUrls: ['./checkout-page.component.css']
})
export class CheckoutPageComponent implements OnInit {
  currentUser: any;
  vinyls : Vinyl[] = [];
  cart !: Cart;
  sumPrice : number = 0;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private vinylService: VinylService,
    private cartService: CartService,
    private cartContentService: CartContentService
  ) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser')!);
    // this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.cartService.getCartByUserId(this.currentUser.userId).subscribe(
      response => {
        this.cart = response;
        this.loadCartContent();
      }
    );
  }

  sendCart(){
    this.cartService.checkoutUser(this.currentUser.userId).subscribe(
      response =>this.router.navigate(['/order-confirmation', response.orderInfoId])
    );
  }

  loadCartContent() {
    this.cart.cartContents.forEach(
      (content, index) => {
        this.vinylService.getVinylById(content.vinylId).subscribe(
          response => {
            this.vinyls[index] = response;
            this.sumPrice += content.quantity * response.priceCents;
          }
        );
      }
    );

  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
  ngOnInit(): void {

  }

}
