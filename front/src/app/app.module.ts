import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CoordinatesListComponent } from './coordinates-list/coordinates-list.component';
import { HeaderComponent } from './header/header.component';
import { NewCoordinatesComponent } from './new-coordinates/new-coordinates.component';
import {FormsModule, NgModel, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import { LandingPageComponent } from './landing-page/landing-page.component';
import {DistanceCalculateComponent} from "./distance-calculate/distance-calculate.component";
import { UpdateCoordinatesComponent } from './update-coordinates/update-coordinates.component';

@NgModule({
  declarations: [
    AppComponent,
    CoordinatesListComponent,
    HeaderComponent,
    NewCoordinatesComponent,
    LandingPageComponent,
    DistanceCalculateComponent,
    UpdateCoordinatesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
