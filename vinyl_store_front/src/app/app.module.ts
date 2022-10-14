import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
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
import { AdminPageComponent } from './admin-page/admin-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { VinylDialogComponent } from './admin-page/vinyl-dialog/vinyl-dialog.component';
import { MatDialog, MatDialogContent, MatDialogClose, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs'
import { MatInputModule } from '@angular/material/input';
import { SearchBoxComponent } from './form-handler/search-box/search-box.component';



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
    CheckoutPageComponent,
    AdminPageComponent,
    VinylDialogComponent,
    SearchBoxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatTabsModule,
    MatInputModule,
    FormsModule,
    MatDialogModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    //REMOVE THIS WHEN WE GET THE ACTUAL BACKEND RUNNING
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
