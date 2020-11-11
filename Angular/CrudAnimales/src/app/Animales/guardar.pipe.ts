import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'guardar'
})
export class GuardarPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
