import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {CoffeeCreatorComponent} from "./coffee-creator/coffee-creator.component";
import {HttpClientModule} from "@angular/common/http";
import {PieCreatorComponent} from "./pie-creator/pie-creator.component";
import {NgIf} from "@angular/common";
import {ShopsComponent} from "./shops/shops.component";
import {OrdersComponent} from "./orders/orders.component";
import {ReviewsComponent} from "./reviews/reviews.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, CoffeeCreatorComponent, HttpClientModule, PieCreatorComponent, NgIf, ShopsComponent, OrdersComponent, ReviewsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
  isCoffee = false
  isPie = false
  isCat = false
  isOrders = false
  isReviews = false

  setCoffee() {
    this.isPie = false
    this.isCat = false
    this.isOrders = false
    this.isReviews = false
    this.isCoffee = !this.isCoffee
  }

  setReviews() {
    this.isPie = false
    this.isCat = false
    this.isOrders = false
    this.isCoffee = false
    this.isReviews = !this.isReviews
  }

  setPie() {
    this.isReviews = false
    this.isCoffee = false
    this.isCat = false
    this.isOrders = false
    this.isPie = !this.isPie
  }

  setCat() {
    this.isReviews = false
    this.isCoffee = false
    this.isPie = false
    this.isOrders = false
    this.isCat = !this.isCat
  }

  setOrders() {
    this.isReviews = false
    this.isCoffee = false
    this.isPie = false
    this.isCat = false
    this.isOrders = !this.isOrders
  }
}
