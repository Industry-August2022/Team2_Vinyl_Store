import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormHandlerComponent } from './form-handler/form-handler.component';
import { RegisterComponent } from './register/register.component';
import { tempBackendProvider } from './temp-backend';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorInterceptor } from './error.interceptor';
import { ShopComponent } from './shop/shop.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { CheckoutPageComponent } from './checkout-page/checkout-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    FormHandlerComponent,
    RegisterComponent,
    ShopComponent,
    UserProfileComponent,
    ProductPageComponent,
    OrderConfirmationComponent,
    CheckoutPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    //REMOVE THIS WHEN WE GET THE ACTUAL BACKEND RUNNING
    tempBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
