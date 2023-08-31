import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-new-coordinates',
  templateUrl: './new-coordinates.component.html',
  styleUrls: ['./new-coordinates.component.scss']
})
export class NewCoordinatesComponent implements OnInit {

  coordinatesForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.coordinatesForm = this.formBuilder.group({
      latitude: [null],
      longitude: [null]
    });
  }

  onSubmitForm(){
    console.log(this.coordinatesForm.value)
  }

}
