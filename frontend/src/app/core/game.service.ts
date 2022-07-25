import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../common/models/Game';


@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http : HttpClient) { }

  getGames() : Observable<Game[]> {
    return this.http.get<Game[]>("http://localhost:8080/games")
  }
  
  ngOnInit(): void {
    
  }
}
