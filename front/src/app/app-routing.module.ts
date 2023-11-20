import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {NewCoordinatesComponent} from "./coordinates/components/new-coordinates/new-coordinates.component";
import {CoordinatesListComponent} from "./coordinates/components/coordinates-list/coordinates-list.component";
import {LandingPageComponent} from "./landing-page/components/landing-page/landing-page.component";
import {DistanceCalculateComponent} from "./coordinates/components/distance-calculate/distance-calculate.component";
import { UpdateCoordinatesComponent } from './coordinates/components/update-coordinates/update-coordinates.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent},
  { path: 'new-coordinates', component: NewCoordinatesComponent },
  { path: 'update-coordinates/:id', component: UpdateCoordinatesComponent },
  { path: 'coordinates-list', component: CoordinatesListComponent },
  { path: 'distance-calculate', component: DistanceCalculateComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
