import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Artist } from '../api-classes/artist';
import { Vinyl } from '../api-classes/vinyl';
import { ArtistService } from '../services/artist.service';
import { AuthenticationService } from '../services/authentication.service';
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

  constructor(
    private router:Router,
    private authService: AuthenticationService,
    private vinylService: VinylService,
    private artistService: ArtistService,
    private routes: ActivatedRoute
  ){
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.vinylService.getVinylById(parseInt(this.routes.snapshot.paramMap.get('id')!)).subscribe(
      response => {
        this.vinyl = response;
        this.artistService.getArtistById(this.vinyl.artistId).subscribe(
          response => this.artist = response
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
