import {AdditiveModel} from "./AdditiveModel";

export class CoffeeModel {

  id: number | null
  milk: AdditiveModel | null
  bean: AdditiveModel | null
  syrup: AdditiveModel | null
  size: AdditiveModel | null

  constructor(id: number, milk: AdditiveModel | null, bean: AdditiveModel | null, syrup: AdditiveModel | null, size: AdditiveModel | null) {
    this.id = id;
    this.milk = milk;
    this.bean = bean;
    this.syrup = syrup;
    this.size = size;
  }

}
