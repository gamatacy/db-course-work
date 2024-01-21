import {ShopModel} from "./ShopModel";

export class CatModel {

  id: number
  age: number
  gender: boolean
  photo_url: string
  shop: ShopModel

  constructor(id: number, age: number, gender: boolean, photo_url: string, shop: ShopModel) {
    this.id = id;
    this.age = age;
    this.gender = gender;
    this.photo_url = photo_url;
    this.shop = shop;
  }

}
