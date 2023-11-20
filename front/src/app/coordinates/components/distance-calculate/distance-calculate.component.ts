import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../../../core/service/coordinates.service";
import {Observable, tap} from "rxjs";
import {Coordinates} from "../../../core/models/coordinates.models";
import {CoupleOfId} from "../../../core/models/CoupleOfId";

@Component({
  selector: 'app-distance-calculate',
  templateUrl: './distance-calculate.component.html',
  styleUrls: ['./distance-calculate.component.scss']
})
export class DistanceCalculateComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;
  idOne!: string;
  idTwo!: string;
  coupleOfId!: CoupleOfId;
  result!: number;
  referenceDistance!: number;


  constructor(private coordinatesService: CoordinatesService) {
  }

  ngOnInit(): void {
    this.coordinates$ = this.coordinatesService.getCoordinates();
    this.referenceDistance = 10;
  }

  onCalculate(): void {
    this.coupleOfId = new CoupleOfId(this.idOne, this.idTwo);
    this.coordinatesService.sendCoupleOfId(this.coupleOfId).pipe(
      tap(value => this.result = value)
    ).subscribe();
  }
}
