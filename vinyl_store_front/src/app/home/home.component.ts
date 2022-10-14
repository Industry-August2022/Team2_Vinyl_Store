import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import { first } from 'rxjs';
import { Genre } from '../api-classes/genre';
import { GenreService } from '../services/genre.service';
import { Vinyl } from '../api-classes/vinyl';
import { Artist } from '../api-classes/artist';
import { CategoryService } from '../services/category.service';
import { ArtistService } from '../services/artist.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: any;
  users: any[] = [];
  genres !: Genre[];
  bestVinyls !: Vinyl[];
  staffVinyls !: Vinyl[];
  artists !: Artist[];
  constructor(
    private router:Router,
    private authService: AuthenticationService,
    private userService: UserService,
    private genreService: GenreService,
    private categoryService: CategoryService,
    private artistService: ArtistService
  ){
    this.currentUser = JSON.parse(localStorage.getItem('currentUser')!);
    // this.authService.currentUser.subscribe(x => this.currentUser = x);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  private loadAllUsers() {
    this.userService.getAllUsers()
    .pipe(first())
    .subscribe(users => this.users = users);
  }

  ngOnInit(): void {
    this.loadAllUsers();

    this.genreService.getAllGenres().subscribe(
      response => {
        this.genres = response;
        this.genres.sort((a, b) => a.genreId < b.genreId?-1:1);
      }
    );
    this.categoryService.getCategoryById(1).subscribe(
      response => {
        this.bestVinyls = response.vinyl;
      }
    );

    this.artistService.getAllArtists().subscribe(
      response => {
        this.artists = response;
        this.artists.sort((a, b) => a.artistId < b.artistId ? -1 : 1);
      }
    );
  }

}
