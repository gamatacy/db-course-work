import {Component, OnInit} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {PieService} from "../services/pie.service";
import {OrderService} from "../services/order.service";
import {AdditiveModel} from "../model/AdditiveModel";
import {CoffeeModel} from "../model/CoffeeModel";
import {PieModel} from "../model/PieModel";

@Component({
  selector: 'app-pie-creator',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './pie-creator.component.html',
  styleUrl: './pie-creator.component.css'
})
export class PieCreatorComponent implements OnInit {

  constructor(private pieService: PieService, protected orderService: OrderService) {
  }

  sizes: AdditiveModel[] = []
  currentSize: AdditiveModel | null = null

  fillings: AdditiveModel[] = []
  currentFilling: AdditiveModel | null = null

  getSize() {
    this.pieService.getSize().subscribe(
      res => {
        this.sizes = res
        this.currentSize = this.sizes[0]
      }
    )
  }

  selectSize(size: AdditiveModel) {
    this.currentSize = size
  }

  getFilling() {
    this.pieService.getFilling().subscribe(
      res => {
        this.fillings = res
        this.currentFilling = this.fillings[0]
      }
    )
  }

  selectFilling(filling: AdditiveModel) {
    this.currentFilling = filling
  }

  addToCart() {
    this.orderService.piesCart.push(
      new PieModel(0, this.currentFilling, this.currentSize)
    )
  }

  ngOnInit(): void {
    this.getSize()
    this.getFilling()
  }


}
