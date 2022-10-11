import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ShopComponent } from './shop/shop.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'shop', component: ShopComponent},
  { path: '', component: HomeComponent}

  //just in case something is routing to nowhere
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
