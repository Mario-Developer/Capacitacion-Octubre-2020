import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'listar'
})
export class ListarPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
