import {CoffeeModel} from "./CoffeeModel";
import {PieModel} from "./PieModel";
import {ClientModel} from "./ClientModel";
import {StatusModel} from "./StatusModel";

export class OrderModel {
  id: number
  price: number
  address: string
  status: StatusModel
  client: ClientModel
  coffee: CoffeeModel[]
  pies: PieModel[]


  constructor(id: number, price: number, address: string, status: StatusModel, client: ClientModel, coffee: CoffeeModel[], pies: PieModel[]) {
    this.id = id;
    this.price = price;
    this.address = address;
    this.status = status;
    this.client = client;
    this.coffee = coffee;
    this.pies = pies;
  }

}
