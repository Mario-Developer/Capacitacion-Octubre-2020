import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'editar'
})
export class EditarPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
