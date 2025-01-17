import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidationResponse } from '../models/validation-response.model';
import { environment } from '../../enviroments/environment';
//import { environment } from '../../enviroments/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class ValidationService {
  // Definir la URL del endpoint
  private readonly endpoint = `${environment.apiBaseUrl}/validate`;

  // Inyectar el servicio HttpClient
  constructor(private http: HttpClient) {}

  // Definir el método para validar la placa
  validatePlate(vehicle: {
    plate: string;
    date: string;
    hour: string;
  }): Observable<ValidationResponse> {
    // Realizar la petición POST al endpoint
    return this.http.post<ValidationResponse>(this.endpoint, vehicle);
  }
}
