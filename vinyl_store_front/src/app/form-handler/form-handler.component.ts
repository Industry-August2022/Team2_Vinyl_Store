import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { AuthenticationService } from '../authentication.service';


@Component({
  selector: 'app-form-handler',
  templateUrl: './form-handler.component.html',
  styleUrls: ['./form-handler.component.css']
})
export class FormHandlerComponent implements OnInit {
  loading = false;
  returnedUrl: string | undefined;
  error:string | undefined;
  submitted = false;
  registerForm = new FormGroup({

  });

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authService: AuthenticationService) {
                if (this.authService.currentUserValue){
                  this.router.navigate(['/home']);
                }
              }

  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  get access(){return this.loginForm.controls;}

  onSubmit(){
    this.submitted = true;
    console.log("The form has been submitted.\nThe username: " + this.access.email.value + "\nThe pass: "
    + this.access.password.value);

    this.loading = true;
    this.authService.login(this.access.email.value, this.access.password.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnedUrl]);
        },
        error => {
          this.error = error;
          this.loading = false;
        }
      )
  }

  ngOnInit(): void {
    this.returnedUrl = this.route.snapshot.queryParams['returnedUrl'] || '/';
  }

}
