import { Component, OnInit } from '@angular/core';

// import Swiper core and required components
import SwiperCore , {
  Navigation,
  Pagination,
  EffectCoverflow,
  Scrollbar,
  A11y,
  Virtual,
  Zoom,
  Autoplay,
  Thumbs,
  Controller,
} from 'swiper';
import { GameService } from '../core/game.service';
import { Game } from '../common/models/Game';

// install Swiper components
SwiperCore.use([
  Navigation,
  Pagination,
  Scrollbar,
  A11y,
  EffectCoverflow,
  Virtual,
  Zoom,
  Autoplay,
  Thumbs,
  Controller
]);

@Component({
  selector: 'app-featured',
  templateUrl: './featured.component.html',
  styleUrls: ['./featured.component.scss']
})
export class FeaturedComponent implements OnInit {

  games: Game[] = [];

  constructor(private gameService : GameService) {
   }

  getGames(): void {
    this.gameService.getGames().subscribe(
      games => {
        this.games = games;

      },
      err => {
        console.log(err);
      }
    )
  }

  ngOnInit(): void {
    this.getGames();

  }

}
