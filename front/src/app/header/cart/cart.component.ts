import {Component} from '@angular/core';
import {OrderService} from "../../services/order.service";
import {NgForOf, NgIf} from "@angular/common";
import {PieModel} from "../../model/PieModel";
import {CoffeeModel} from "../../model/CoffeeModel";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    FormsModule
  ],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {

  constructor(protected orderService: OrderService) {
  }

  address: string = ""


  getPrice() {
    let price = 0

    this.orderService.coffeeCart.forEach(
      coffee => price += (coffee.size?.price || 0) + (coffee.milk?.price || 0) + (coffee.syrup?.price || 0) + (coffee.bean?.price || 0)
    )

    this.orderService.piesCart.forEach(
      pie => price += (pie.filling?.price || 0) + (pie.size?.price || 0)
    )

    return price

  }

  deletePie(pie: PieModel) {
    this.orderService.piesCart.forEach((item, index) => {
      if (item === pie) {
        this.orderService.piesCart.splice(index, 1);
        return
      }
    });
  }

  deleteCoffee(coffee: CoffeeModel) {
    this.orderService.coffeeCart.forEach((item, index) => {
      if (item === coffee) {
        this.orderService.coffeeCart.splice(index, 1);
        return
      }
    });
  }

  createOrder() {
    this.orderService.createOrder(this.address, 4, this.orderService.coffeeCart, this.orderService.piesCart).subscribe(
      res => {
        this.orderService.coffeeCart = []
        this.orderService.piesCart = []
      }
    )


  }


}
