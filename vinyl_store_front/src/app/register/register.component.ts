import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
import { RegisterHolder } from '../api-classes/auth/register-holder';

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
    private authService: AuthenticationService
  ) {
      //go home when logged in
      if (this.authService.currentUserValue){
        this.router.navigate(['/home']);
    }
   }

  registerForm = new FormGroup({
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

    this.authService.register(new RegisterHolder(this.registerForm.get("address")!.value!,
        this.registerForm.get("email")!.value!, this.registerForm.get("password")!.value!, this.registerForm.get("paymentInfo")!.value!))
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
