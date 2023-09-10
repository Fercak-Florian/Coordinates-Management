import {Component, OnInit} from '@angular/core';
import {CoordinatesService} from "../service/coordinates.service";
import {Coordinates} from "../models/coordinates.models";
import {Observable} from "rxjs";
import {logMessages} from "@angular-devkit/build-angular/src/tools/esbuild/utils";

@Component({
  selector: 'app-coordinates-list',
  templateUrl: './coordinates-list.component.html',
  styleUrls: ['./coordinates-list.component.scss']
})
export class CoordinatesListComponent implements OnInit {

  coordinates$!: Observable<Coordinates[]>;

  /*Pour utiliser un service, on l'instantie grâce au constructor*/

  /*Ici on onject coordinatesService dans la classe CoordinatesListComponent*/
  constructor(private coordinatesService: CoordinatesService) {
  }

  /*La méthode  ngOnInit()  est appelée automatiquement par Angular au moment
   de la création de chaque instance du component.
   Elle permet notamment d'initialiser des propriétés.*/
  ngOnInit(): void {
    this.coordinates$ = this.coordinatesService.getCoordinates();

  }

  onDelete(id: string): void {
    this.coordinatesService.deleteCoordinates(id).subscribe();
  }
}
