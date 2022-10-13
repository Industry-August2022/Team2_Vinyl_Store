import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'vinyl_store_front';

  
}
export let apiUrl:string = "http://localhost:5000/api/";