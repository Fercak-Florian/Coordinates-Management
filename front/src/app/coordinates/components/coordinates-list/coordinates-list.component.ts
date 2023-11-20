import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../../../core/service/coordinates.service";
import {Coordinates} from "../../../core/models/coordinates.models";
import {Observable, tap} from "rxjs";
import { Router } from '@angular/router';

@Component({
  selector: 'app-coordinates-list',
  templateUrl: './coordinates-list.component.html',
  styleUrls: ['./coordinates-list.component.scss']
})
export class CoordinatesListComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;

  /*Pour utiliser un service, on l'instantie grâce au constructor*/

  /*Ici on onject coordinatesService dans la classe CoordinatesListComponent*/
  constructor(private coordinatesService: CoordinatesService, private router: Router) {
  }

  /*La méthode  ngOnInit()  est appelée automatiquement par Angular au moment
   de la création de chaque instance du component.
   Elle permet notamment d'initialiser des propriétés.*/
  ngOnInit(): void {
    this.coordinates$ = this.coordinatesService.getCoordinates();

  }

  onUpdate(id: string): void {
    this.router.navigateByUrl(`update-coordinates/${id}`);
  }

  onDelete(id: string): void {
    this.coordinatesService.deleteCoordinates(id).pipe(
      tap(() => this.ngOnInit())
      ).subscribe();
  }
}
