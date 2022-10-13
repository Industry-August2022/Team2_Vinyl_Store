import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Artist } from '../api-classes/artist';
import { Category } from '../api-classes/category';
import { Genre } from '../api-classes/genre';
import { Studio } from '../api-classes/studio';
import { Vinyl } from '../api-classes/vinyl';
import { ArtistService } from '../services/artist.service';
import { AuthenticationService } from '../services/authentication.service';
import { CategoryService } from '../services/category.service';
import { GenreService } from '../services/genre.service';
import { StudioService } from '../services/studio.service';
import { UserService } from '../services/user.service';
import { VinylService } from '../services/vinyl.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { VinylDialogComponent } from './vinyl-dialog/vinyl-dialog.component';
import { vinylDialogData } from '../api-classes/vinylDialogData';


@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

  currentUser: any;
  vinyls !: Vinyl[];
  artists !: Artist[];
  genres !: Genre[];
  studios !: Studio[];
  categories !: Category[];
  title!: string;
  

  //variables for vinyl dialog



  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private vinylService: VinylService,
    private artistService: ArtistService,
    private genreService: GenreService,
    private studioService: StudioService,
    private categoryService: CategoryService,
    private userService: UserService,
    public dialog: MatDialog
  ) {
    this.authService.currentUser.subscribe(x => this.currentUser = x);
    this.vinylService.getAllVinyl().subscribe(
      response => this.vinyls = response
      
    );
  }


  openDialog(): void {
    const dialogRef = this.dialog.open(VinylDialogComponent, {
      width: '300px',
      data: {
        name: this.title
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      this.title = result;
      console.log("here is a thing: " + this.title);
    });

  }


  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
    this.artistService.getAllArtists().subscribe(
      response => {
        this.artists = response;
        this.artists.sort((a, b) => a.artistId < b.artistId ? -1 : 1);
      }
    );

    this.genreService.getAllGenres().subscribe(
      response => {
        this.genres = response;
        this.genres.sort((a, b) => a.genreId < b.genreId ? -1 : 1);
      }
    );

    this.studioService.getAllStudios().subscribe(
      response => {
        this.studios = response;
        this.studios.sort((a, b) => a.studioId < b.studioId ? -1 : 1);
      }
    );

    this.categoryService.getAllCategorys().subscribe(
      response => {
        this.categories = response;
        this.categories.sort((a, b) => a.categoryId < b.categoryId ? -1 : 1);
      }
    );

  }

}
