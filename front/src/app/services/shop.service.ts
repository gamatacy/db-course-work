import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ShopModel} from "../model/ShopModel";
import {CatModel} from "../model/CatModel";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  url = 'http://localhost:52520/api/shop';

  constructor(private http: HttpClient) {
  }

  getShops() {
    return this.http.get<ShopModel[]>(this.url,{
      withCredentials: true
    })
  }

  getCats(shopId: number){
    return this.http.get<CatModel[]>(this.url + `/cats?shop_id=${shopId}`,{
      withCredentials: true
    })
  }

}
