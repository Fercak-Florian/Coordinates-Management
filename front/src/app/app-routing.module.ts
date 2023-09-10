import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {NewCoordinatesComponent} from "./new-coordinates/new-coordinates.component";
import {CoordinatesListComponent} from "./coordinates-list/coordinates-list.component";
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {DistanceCalculateComponent} from "./distance-calculate/distance-calculate.component";

const routes: Routes = [
  { path: "", component: LandingPageComponent},
  { path: "new-coordinates", component: NewCoordinatesComponent },
  { path: "coordinates-list", component: CoordinatesListComponent },
  { path: "distance-calculate", component: DistanceCalculateComponent}
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
