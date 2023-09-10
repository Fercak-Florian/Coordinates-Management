import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../service/coordinates.service";
import {Observable, pipe} from "rxjs";
import {Coordinates} from "../models/coordinates.models";

@Component({
  selector: 'app-distance-calculate',
  templateUrl: './distance-calculate.component.html',
  styleUrls: ['./distance-calculate.component.scss']
})
export class DistanceCalculateComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;

  constructor(private coordinatesService: CoordinatesService) {
  }

  ngOnInit(): void {
    this.coordinates$ = this.coordinatesService.getCoordinates();
  }

  onCalculate(): void {

  }
}
