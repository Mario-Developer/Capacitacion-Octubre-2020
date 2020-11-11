import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'eliminar'
})
export class EliminarPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
