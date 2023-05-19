import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { RESTAPIServiceService } from '../restapiservice.service';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  
datos: any[]=[]; // Variable para almacenar los datos
displayedColumns: string[] = ['businessID', 'email','phone','sharedKey','starDate','actions']; // Columnas a mostrar en la tabla
dataSource: MatTableDataSource<any> ; // Fuente de datos para la tabla
@ViewChild(MatSort) sort: MatSort | undefined ; // Referencia al componente MatSort

  
  constructor(private restAPIService: RESTAPIServiceService) { 
    this.dataSource = new MatTableDataSource<any>([]);
    this.obtenerDatosComponente();
  }
  public obtenerDatosComponente() {
    this.restAPIService.getComponentData().subscribe(
      (response) => {
      this.datos = response; // Asignar los datos recibidos a la variable 'datos'
      this.dataSource = new MatTableDataSource<any>(this.datos); // Crear instancia de MatTableDataSource con los datos
      if (this.sort) {
        this.dataSource.sort = this.sort; // Asignar el componente MatSort a la fuente de datos si está definido
      }
      console.log(response); // Imprimir la respuesta en la consola
      },
      (error) => {
        console.error(error); // Manejar el error en caso de que ocurra
      }
    );
  }
  public delete(element: any) {
    console.log(element);
    // Realizar la solicitud de eliminación al backend utilizando el servicio RESTAPIServiceService
    this.restAPIService.deleteComponentData(element).subscribe(
      () => {
        // Eliminar el elemento de la variable 'datos'
        const index = this.datos.indexOf(element);
        console.log(index);
        if (index >= 0) {
          this.datos.splice(index, 1);
          this.dataSource.data = this.datos; // Actualizar la fuente de datos de la tabla
        }
      },
      (error) => {
        console.error(error); // Manejar el error en caso de que ocurra
      }
    );
  }

}
