import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../service/coordinates.service";
import {Observable, pipe} from "rxjs";
import {Coordinates} from "../models/coordinates.models";
import {FormBuilder, FormGroup, NgModel} from "@angular/forms";

@Component({
  selector: 'app-distance-calculate',
  templateUrl: './distance-calculate.component.html',
  styleUrls: ['./distance-calculate.component.scss']
})
export class DistanceCalculateComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;
  // coupleOfId!: FormGroup;
  idOne!: string;
  idTwo!: string;


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
    console.log(this.idOne);
    console.log(this.idTwo);
  }
}
