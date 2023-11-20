import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoordinatesListComponent } from './components/coordinates-list/coordinates-list.component';
import { NewCoordinatesComponent } from './components/new-coordinates/new-coordinates.component';
import { UpdateCoordinatesComponent } from './components/update-coordinates/update-coordinates.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DistanceCalculateComponent } from './components/distance-calculate/distance-calculate.component';



@NgModule({
  declarations: [
    NewCoordinatesComponent,
    UpdateCoordinatesComponent,
    CoordinatesListComponent,
    DistanceCalculateComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    NewCoordinatesComponent,
    UpdateCoordinatesComponent,
    CoordinatesListComponent,
    DistanceCalculateComponent
  ]
})
export class CoordinatesModule { }
