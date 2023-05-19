import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RESTAPIServiceService {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  public getComponentData(): Observable<any> {
    const url = 'http://localhost:8082/componente';
    return this.http.get(url, this.httpOptions);
  }
  public deleteComponentData(element: any): Observable<any> {
    const url = `http://localhost:8082/componente/${element.id}`; // URL específica para eliminar el elemento correspondiente al 'id' proporcionado
    return this.http.delete(url);
  }
}