import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  loading = false;
  submitted = false;
  error: string | undefined;

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private userService: UserService
  ) {
      //go home when logged in
      if (this.authService.currentUserValue){
        this.router.navigate(['/home']);
    }
   }

  registerForm = new FormGroup({
    fullName: new FormControl(''),
    email: new FormControl(''),
    address: new FormControl(''),
    paymentInfo: new FormControl(''),
    password: new FormControl('')

  })

  get access() {
    return this.registerForm.controls;
  }

  onSubmit(){
    this.submitted = true;
    this.loading = true;

    this.userService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['/login'], {queryParams: {registered: true}});
        },
        error => {
          this.error = error;
          this.loading = false;
        });
  }
  ngOnInit(): void {
  }

}
