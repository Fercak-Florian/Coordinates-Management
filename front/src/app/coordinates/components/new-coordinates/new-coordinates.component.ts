import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { CoordinatesService } from "../../../core/service/coordinates.service";
import { tap } from 'rxjs';

@Component({
  selector: 'app-new-coordinates',
  templateUrl: './new-coordinates.component.html',
  styleUrls: ['./new-coordinates.component.scss']
})
export class NewCoordinatesComponent {

  constructor(private coordinatesService: CoordinatesService, private router: Router, private formBuilder: FormBuilder) {
  }

  coordinatesForm = this.formBuilder.group({
    name: this.formBuilder.control('', [Validators.required]),
    latitude: this.formBuilder.control('', [Validators.required]),
    longitude: this.formBuilder.control('', [Validators.required])
  });

  onSubmitForm(){
    this.coordinatesService.addCoordinates(this.coordinatesForm.value).pipe(
      tap(() => this.router.navigateByUrl('coordinates-list'))
    )
    .subscribe();
  }
}