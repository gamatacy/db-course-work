import {Component} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {ShopService} from "../services/shop.service";
import {ShopModel} from "../model/ShopModel";
import {CatModel} from "../model/CatModel";

@Component({
  selector: 'app-shops',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './shops.component.html',
  styleUrl: './shops.component.css'
})
export class ShopsComponent {
  constructor(private shopService: ShopService) {
  }

  ngOnInit(): void {
    this.getShops()
  }

  shops: ShopModel[] = []
  cats: CatModel[] = []

  getShops() {
    this.shopService.getShops().subscribe(
      res => this.shops = res
    )
  }

  getCats(id: number) {
    this.shopService.getCats(id).subscribe(
      res => this.cats = res
    )
  }

}
