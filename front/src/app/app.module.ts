import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CoordinatesListComponent } from './coordinates-list/coordinates-list.component';
import { HeaderComponent } from './header/header.component';
import { NewCoordinatesComponent } from './new-coordinates/new-coordinates.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CoordinatesListComponent,
    HeaderComponent,
    NewCoordinatesComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
