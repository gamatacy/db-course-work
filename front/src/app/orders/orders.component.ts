import {Component, OnInit} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {OrderService} from "../services/order.service";
import {OrderModel} from "../model/OrderModel";

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit {

  constructor(private orderService: OrderService) {
  }


  orders: OrderModel[] = []

  getOrders() {
    this.orderService.getOrders().subscribe(
      res => {
        this.orders = res
        //@ts-ignore
        console.log(this.orders[0].status.name)
      }
    )
  }

  ngOnInit(): void {
    this.getOrders()
  }

}
