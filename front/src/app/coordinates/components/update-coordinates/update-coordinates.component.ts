import { Component, OnInit } from '@angular/core';
import { CoordinatesService } from '../../../core/service/coordinates.service';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Coordinates } from '../../../core/models/coordinates.models';
import { Observable, take, tap } from 'rxjs';

@Component({
  selector: 'app-update-coordinates',
  templateUrl: './update-coordinates.component.html',
  styleUrls: ['./update-coordinates.component.scss']
})
export class UpdateCoordinatesComponent implements OnInit{

  id!: string;
  coordinates$!: Observable<Coordinates>;

  constructor(private coordinatesService: CoordinatesService, private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute){
  }

  ngOnInit(): void {
    /*Permet de récupérer l'id dans l'url de la page actuelle*/
    this.id = this.route.snapshot.params['id'];

    const lastValue$ = this.coordinatesService.getCoordinatesById(this.id).pipe(take(1))
    lastValue$.subscribe((value) => {
  
      /*Permet de pré-remplir les champs du formulaire*/
      this.coordinatesForm.controls['name'].setValue(value.name);
      this.coordinatesForm.controls['latitude'].setValue(value.latitude.toString());
      this.coordinatesForm.controls['longitude'].setValue(value.longitude.toString());
    }
  );
}

  coordinatesForm = this.formBuilder.group({
    name: this.formBuilder.control(''),
    latitude: this.formBuilder.control(''),
    longitude: this.formBuilder.control('')
  });

  onCancel(): void {
    this.router.navigateByUrl('coordinates-list');
  }

  onUpdate(): void{
    this.coordinatesService.updateCoordinates(this.coordinatesForm.value, this.id).pipe(
      tap(() => this.router.navigateByUrl('coordinates-list'))
    )
    .subscribe();
  }

}
