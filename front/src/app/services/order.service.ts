import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../model/OrderModel";
import {CoffeeModel} from "../model/CoffeeModel";
import {PieModel} from "../model/PieModel";
import {CoffeeService} from "./coffee.service";
import {PieService} from "./pie.service";
import {ClientService} from "./client.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  url = 'http://localhost:52520/api/order';

  coffeeCart: CoffeeModel[] = []
  piesCart: PieModel[] = []

  constructor(private http: HttpClient, private coffeeService: CoffeeService, private pieService: PieService, private clientService: ClientService) {
  }

  getOrder(orderId: number) {
    return this.http.get<OrderModel>(this.url + `?order_id=${orderId}`, {
      withCredentials: true
    })
  }

  getOrders() {
    return this.http.get<OrderModel[]>(this.url + "/all", {
      withCredentials: true
    })
  }

  createOrder(address: string, clientId: number, coffee: CoffeeModel[], pies: PieModel[]) {

    console.log(this.coffeeCart)
    console.log(this.piesCart)

    this.coffeeCart.forEach(
      coffeeEntity => {
        console.log(coffeeEntity)
        this.coffeeService.createCoffee(
          // @ts-ignore
          coffeeEntity.bean,
          coffeeEntity.milk,
          coffeeEntity.syrup,
          coffeeEntity.size
        ).subscribe()
      }
    )

    this.piesCart.forEach(
      pie => this.pieService.createPie(
        // @ts-ignore
        pie.filling,
        pie.size
      ).subscribe()
    )

    return this.http.post(this.url, {
      address: address,
      client_id: this.clientService.user?.id,
      coffee,
      pies
    }, {
      withCredentials: true
    })
  }

}
