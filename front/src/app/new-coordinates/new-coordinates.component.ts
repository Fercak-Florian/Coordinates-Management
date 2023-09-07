import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CoordinatesService} from "../service/coordinates.service";

@Component({
  selector: 'app-new-coordinates',
  templateUrl: './new-coordinates.component.html',
  styleUrls: ['./new-coordinates.component.scss']
})
export class NewCoordinatesComponent implements OnInit {

  coordinatesForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private coordinatesService: CoordinatesService) { }

  ngOnInit(): void {
    this.coordinatesForm = this.formBuilder.group({
      name: [null],
      latitude: [null],
      longitude: [null]
    });
  }

  onSubmitForm(){
    console.log(this.coordinatesForm.value);
    this.coordinatesService.addCoordinates(this.coordinatesForm.value).subscribe();
  }
}
