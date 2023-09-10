import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../service/coordinates.service";
import {map, Observable, tap} from "rxjs";
import {Coordinates} from "../models/coordinates.models";
import {FormBuilder} from "@angular/forms";
import {CoupleOfId} from "../models/CoupleOfId";

@Component({
  selector: 'app-distance-calculate',
  templateUrl: './distance-calculate.component.html',
  styleUrls: ['./distance-calculate.component.scss']
})
export class DistanceCalculateComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;
  // coupleOfId!: FormGroup;
  idOne: string = "";
  idTwo: string = "";
  coupleOfId!: CoupleOfId;


  constructor(private coordinatesService: CoordinatesService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.coordinates$ = this.coordinatesService.getCoordinates();
    /*this.coupleOfId = this.formBuilder.group({
      idOne: [null],
      idTwo: [null]
    });*/
  }

  onCalculate(): void {
    this.coupleOfId = new CoupleOfId(this.idOne, this.idTwo);
    // this.coupleOfId.idOne = this.idOne;
    // this.coupleOfId.idTwo = this.idTwo;
    // console.log('valeur de idOne : ' + this.coupleOfId.idOne);
    // console.log('valeur de idTwo : ' + this.coupleOfId.idTwo);
     console.log('valeur de idOne : ' + this.idOne);
     console.log('valeur de idTwo : ' + this.idTwo);
    this.coordinatesService.sendCoupleOfId(this.coupleOfId).pipe(
      map(value => 'La distance est de ' + value + ' km'),
      tap(value => console.log(value))
    ).subscribe();
  }
}
