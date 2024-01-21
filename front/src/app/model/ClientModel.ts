import {CoffeeModel} from "./CoffeeModel";

export class ClientModel {

  id: number
  name: string
  registration_date: string
  favourite_coffee: CoffeeModel

  constructor(id: number, name: string, registration_date: string, favourite_coffee: CoffeeModel) {
    this.id = id;
    this.name = name;
    this.registration_date = registration_date;
    this.favourite_coffee = favourite_coffee;
  }
}
