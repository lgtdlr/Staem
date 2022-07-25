import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SwiperModule } from 'swiper/angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FeaturedComponent } from './featured/featured.component';
import { ListingComponent } from './listing/listing.component';
import { GameItemComponent } from './game-item/game-item.component';
import { HeaderComponent } from './header/header.component';
import { ListingHeaderComponent } from './listing/listing-header/listing-header.component';
import { ButtonComponent } from './button/button.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FeaturedComponent,
    ListingComponent,
    GameItemComponent,
    HeaderComponent,
    ListingHeaderComponent,
    ButtonComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    SwiperModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
