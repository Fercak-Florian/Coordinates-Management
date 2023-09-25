import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CoordinatesService} from "../service/coordinates.service";
import { tap } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-coordinates',
  templateUrl: './new-coordinates.component.html',
  styleUrls: ['./new-coordinates.component.scss']
})
export class NewCoordinatesComponent implements OnInit {

  coordinatesForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private coordinatesService: CoordinatesService, private router: Router) { }

  ngOnInit(): void {
    this.coordinatesForm = this.formBuilder.group({
      name: [null],
      latitude: [null],
      longitude: [null]
    });
  }

  onSubmitForm(){
    this.coordinatesService.addCoordinates(this.coordinatesForm.value).pipe(
      tap(() => this.router.navigateByUrl('coordinates-list'))
    )
    .subscribe();
  }
}
