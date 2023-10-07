import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Coordinates } from "../models/coordinates.models";


@Injectable({
  providedIn: 'root'
})
/*@Injectable est utilisé pour déclarer un service */
export class CoordinatesService {

  constructor(private http: HttpClient) {
  }

  getCoordinates(): Observable<Coordinates[]> {
    return this.http.get<Coordinates[]>('http://localhost:8080/coordinates');
  }

  addCoordinates(formValue: {
    /*id: string,
    name: string,
    latitude: number,
    longitude: number*/
  }): Observable<Coordinates> {
    return this.http.post<Coordinates>('http://localhost:8080/coordinates', formValue);
  }

  deleteCoordinates(id: string): Observable<Coordinates> {
    return this.http.delete<Coordinates>(`http://localhost:8080/coordinates/${id}`);
  }

  sendCoupleOfId(formValue: {
    idOne: string,
    idTwo: string
  }): Observable<number>{
    return this.http.post<number>('http://localhost:8080/couple-of-id', formValue);
  }
}
