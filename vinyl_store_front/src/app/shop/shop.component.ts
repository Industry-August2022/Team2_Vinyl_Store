import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Artist } from '../api-classes/artist';
import { Genre } from '../api-classes/genre';
import { Studio } from '../api-classes/studio';
import { Vinyl } from '../api-classes/vinyl';
import { VinylSearchRequest } from '../api-classes/vinyl-search-request';
import { ArtistService } from '../services/artist.service';
import { AuthenticationService } from '../services/authentication.service';
import { GenreService } from '../services/genre.service';
import { SearchService } from '../services/search.service';
import { StudioService } from '../services/studio.service';
import { VinylService } from '../services/vinyl.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  currentUser: any;
  vinyls !: Vinyl[];
  genres !: Genre[];
  artists !: Artist[];
  studios !: Studio[];
  searchRequest: VinylSearchRequest = new VinylSearchRequest(null, 0, 0, 0, null);
  selectedGenre: number = 0;
  selectedArtist: number = 0;
  selectedStudio: number = 0;
  selectedOrder: string = "0";

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private vinylService: VinylService,
    private genreService: GenreService,
    private searchService: SearchService,
    private artistService: ArtistService,
    private studioService: StudioService
  ) {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.vinylService.getAllVinyl().subscribe(
      response => this.vinyls = response
    );
  }

  updateGenreFilter(event: any): void {
    this.selectedGenre = event.target.value;
    this.searchRequest.genreId = this.selectedGenre;


    this.searchService.searchVinyl(this.searchRequest).subscribe(
      response => this.vinyls = response
    );
  }

  updateArtistFilter(event: any): void {
    this.selectedArtist = event.target.value;
    this.searchRequest.artistId = this.selectedArtist;

    this.searchService.searchVinyl(this.searchRequest).subscribe(
      response => this.vinyls = response
    );
  }

  updateStudioFilter(event: any): void {
    this.selectedStudio = event.target.value;
    this.searchRequest.studioId = this.selectedStudio;

    this.searchService.searchVinyl(this.searchRequest).subscribe(
      response => this.vinyls = response
    );
  }

  updateOrderFilter(event: any): void {
    this.selectedOrder = event.target.value;
    this.searchRequest.orderBy = this.selectedOrder;

    this.searchService.searchVinyl(this.searchRequest).subscribe(
      response => this.vinyls = response
    );
  }


  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
    this.genreService.getAllGenres().subscribe(
      response => {
        this.genres = response;
      }
    );

    this.artistService.getAllArtists().subscribe(
      response => {
        this.artists = response;
      }
    );

    this.studioService.getAllStudios().subscribe(
      response => {
        this.studios = response;
      }
    );
  }

}
