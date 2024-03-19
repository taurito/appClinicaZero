import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit{

  ngOnInit(): void{
    const cloud = document.getElementById("cloud");
    const barraLateral = document.querySelector(".barra-lateral");
    const spans = document.querySelectorAll("span");
    const menu = document.querySelector(".menu");
    const contenido = document.querySelector(".contenido");

    menu?.addEventListener("click",()=>{
      barraLateral?.classList.toggle("max-barra-lateral");
      if(barraLateral?.classList.contains("max-barra-lateral")){
        (menu.children[0]as HTMLElement).style.display = "none";
        (menu.children[1]as HTMLElement).style.display = "block";
      }
      else{
        (menu.children[0]as HTMLElement).style.display = "block";
        (menu.children[1]as HTMLElement).style.display = "none";
      }
      if(window.innerWidth<=320){
        barraLateral?.classList.add("mini-barra-lateral");
        contenido?.classList.add("min-contenido");
        spans.forEach((span)=>{
          span.classList.add("oculto");
        })
      }
    });

    cloud?.addEventListener("click", ()=>{
      barraLateral?.classList.toggle("mini-barra-lateral");
      contenido?.classList.toggle("min-contenido");
      spans.forEach((span)=>{
        span.classList.toggle("oculto");
      });
    });
  }
}
