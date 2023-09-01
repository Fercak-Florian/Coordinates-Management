import {Injectable} from "@angular/core";
import {Coordinates} from "../models/coordinates.models";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
/*@Injectable est utilisé pour déclarer un service */
export class CoordinatesService {

  constructor(private http: HttpClient) {
  }

/*Methode de recuperation des coordonnees*/
  getCoordinates(): Observable<Coordinates[]>{
    return this.http.get<Coordinates[]>('http://localhost:8080/coordinates');
  }
}
