import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AdditiveModel} from "../model/AdditiveModel";
import {PieModel} from "../model/PieModel";
import {CoffeeModel} from "../model/CoffeeModel";

@Injectable({
  providedIn: 'root'
})
export class PieService {
  url = 'http://localhost:52520/api/pie';

  constructor(private http: HttpClient) {
  }

  createPie(filling: AdditiveModel, size: AdditiveModel){

    return this.http.post<PieModel>(this.url,{
      filling,
      size
    },{
      withCredentials: true
    })

  }

  getSales(){
    return this.http.get<PieModel[]>(this.url + "/sale",{
      withCredentials: true
    })
  }

  getFilling(){
    return this.http.get<AdditiveModel[]>(this.url + "/filling",{
      withCredentials: true
    })
  }

  getSize(){
    return this.http.get<AdditiveModel[]>(this.url + "/size",{
      withCredentials: true
    })
  }

}
