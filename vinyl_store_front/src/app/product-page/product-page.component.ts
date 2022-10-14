import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Artist } from '../api-classes/artist';
import { Cart } from '../api-classes/cart';
import { CartContent } from '../api-classes/cart-content';
import { Vinyl } from '../api-classes/vinyl';
import { ArtistService } from '../services/artist.service';
import { AuthenticationService } from '../services/authentication.service';
import { CartContentService } from '../services/cart-content.service';
import { CartService } from '../services/cart.service';
import { VinylService } from '../services/vinyl.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  currentUser: any;

  vinyl !: Vinyl;
  artist !: Artist;
  quantity !: string;
  cart: Cart = new Cart(0, 0, []);
  contents: CartContent = new CartContent(0, 0, 0, 0);

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private vinylService: VinylService,
    private artistService: ArtistService,
    private routes: ActivatedRoute,
    private cartService: CartService,
    private cartContentService: CartContentService
  ) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser')!);
    //this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.vinylService.getVinylById(parseInt(this.routes.snapshot.paramMap.get('id')!)).subscribe(
      response => {
        this.vinyl = response;
        this.artistService.getArtistById(this.vinyl.artistId).subscribe(
          response => this.artist = response
        );
      }
    );

  }

  productForm = new FormGroup({
    quantity: new FormControl('')
  });

  get access() { return this.productForm.controls; }
  onSubmit() {
    //console.log("Here is quantity: " + this.access.quantity.value)
    this.quantity = this.access.quantity.value!;
  }

  addToCart() {
    if (!this.authService.currentUserValue){
      this.router.navigate(['/login']);
    }
    this.cartService.getCartByUserId(this.currentUser.userId).subscribe(
      response => {
          this.cart = response;
          this.addContent();
        }
    );
    
  }

  addContent() {
    this.contents = new CartContent(0, this.cart.cartId, this.vinyl.vinylId, parseInt(this.quantity));
    this.cartContentService.addCartContent(this.contents);
    //console.log("Here is the cart Contents: " + this.contents.cartId);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }



  ngOnInit(): void {
  }

}
