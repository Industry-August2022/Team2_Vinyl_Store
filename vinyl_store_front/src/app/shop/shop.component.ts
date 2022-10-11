import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vinyl } from '../api-classes/vinyl';
import { AuthenticationService } from '../services/authentication.service';
import { VinylService } from '../services/vinyl.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  currentUser: any;
  vinyls !: Vinyl[];

  constructor(
    private router:Router,
    private authService: AuthenticationService,
    private vinylService: VinylService
  ){
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.vinylService.getAllVinyl().subscribe(
      response => this.vinyls = response
    );
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
  }

}
