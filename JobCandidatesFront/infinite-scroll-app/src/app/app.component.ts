import { Component, OnInit } from '@angular/core';
import { Candidate } from './model/candidate';
import { CandidateService } from './service/candidate.service';
import { RouterOutlet } from '@angular/router';
import { InfiniteScrollModule } from "ngx-infinite-scroll";
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ InfiniteScrollModule, CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isLoading = false;
  candidates: Candidate[] = [];
  items: Candidate[] = [];
  currentPage=0;
  itemsPerPage=5;
  last=false;
  toggleLoading = ()=> this.isLoading =! this.isLoading;

  constructor(private candidateService: CandidateService){}

  loadData = () => {
    this.toggleLoading();
    this.candidateService.getCandidatesPaged(this.currentPage, 30).subscribe({
      next: response => {
        this.items = response.content;
      },
      error: err => console.log(err),
      complete: () => this.toggleLoading()
    });
  }
  
  ngOnInit(): void {
    this.loadData();
  }

  appendData=()=>{
    this.toggleLoading();
      this.candidateService.getCandidatesPaged(this.currentPage, this.itemsPerPage).subscribe({
      next: response=>{
        this.items = [...this.items,...response.content];
        console.log('res',response)
      },
      error: err=> console.log(err),
      complete:()=>this.toggleLoading()
    })
  }

  onScroll=()=>{
    this.currentPage++;
    this.appendData();
  }
}