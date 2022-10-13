import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';

import { CheckoutPageComponent } from './checkout-page/checkout-page.component';

import { HomeComponent } from './home';
import { LoginComponent } from './login/login.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { RegisterComponent } from './register/register.component';
import { ShopComponent } from './shop/shop.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'shop', component: ShopComponent},
  { path: 'user-profile', component:UserProfileComponent},
  { path: 'order-confirmation', component:OrderConfirmationComponent},
  { path: 'shop/:id', component:ProductPageComponent},
  { path: 'checkout', component:CheckoutPageComponent},
  { path: 'admin-page', component:AdminPageComponent},
  { path: '', component: HomeComponent}

  //just in case something is routing to nowhere
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
