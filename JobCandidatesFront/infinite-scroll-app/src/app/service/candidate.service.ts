import { Injectable } from '@angular/core';
import { Observable, delay, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CandidatePage } from '../model/candidatePage';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  url = "http://localhost:8081/api/candidates";

  constructor(private http:HttpClient) {
  }

  getCandidatesPaged(page:number,size:number): Observable<CandidatePage> {
    if(page != 0)
    {
      page = page +5;
    }

    const params = new HttpParams() 
      .set('page', page)
      .set('size', size);

      if(page == 0)
      {
        return this.http.get<CandidatePage>(this.url , { params });
      }
      else{
        return this.http.get<CandidatePage>(this.url, { params }).pipe(
          delay(500)
        );
      }
     
  } 

 
}
