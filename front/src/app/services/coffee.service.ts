import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CoffeeModel} from "../model/CoffeeModel";
import {AdditiveModel} from "../model/AdditiveModel";

@Injectable({
  providedIn: 'root'
})
export class CoffeeService {

  url = 'http://localhost:52520/api/coffee';

  constructor(private http: HttpClient) {
  }

  createCoffee(beans: AdditiveModel, milk: AdditiveModel, syrup: AdditiveModel, size: AdditiveModel) {
    return this.http.post<CoffeeModel>(this.url, {
      beans: beans,
      milk: milk,
      syrup: syrup,
      size: size
    },{
      withCredentials: true
    })
  }

  getSales() {
    return this.http.get<CoffeeModel[]>(this.url + "/sale",{
      withCredentials: true
    })
  }

  getMilk() {
    return this.http.get<AdditiveModel[]>(this.url + "/milk",{
      withCredentials: true
    })
  }

  getBeans() {
    return this.http.get<AdditiveModel[]>(this.url + "/bean",{
      withCredentials: true
    })
  }

  getSyrups() {
    return this.http.get<AdditiveModel[]>(this.url + "/syrup",{
      withCredentials: true
    })
  }

  getSize() {
    return this.http.get<AdditiveModel[]>(this.url + "/size")
  }

}
