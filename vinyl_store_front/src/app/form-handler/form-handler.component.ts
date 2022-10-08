import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';


@Component({
  selector: 'app-form-handler',
  templateUrl: './form-handler.component.html',
  styleUrls: ['./form-handler.component.css']
})
export class FormHandlerComponent implements OnInit {

  submitted = false;
  registerForm = new FormGroup({

  });

  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  get access(){return this.loginForm.controls;}

  onSubmit(){
    this.submitted = true;
    console.log("The form has been submitted.\nThe username: " + this.access.email.value + "\nThe pass: "
    + this.access.password.value);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
