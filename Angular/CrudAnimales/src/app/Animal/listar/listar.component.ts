import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Animal } from 'src/app/Entidad/Animal';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  animal : Animal[];
  constructor(private service : ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.listarAnimales().subscribe(data=>{
      this.animal=data;
    })
  }
}
